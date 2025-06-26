import express from "express";
import mongoose from "mongoose";
import cors from "cors";
import jwt from "jsonwebtoken";
import dotenv from "dotenv";
import Product from "./models/product.js";
import User from "./models/user.js";

dotenv.config();
const app = express();
const PORT = 5000;
const JWT_SECRET = process.env.JWT_SECRET || "your-secret-key";

app.use(cors());
app.use(express.json());

// MongoDB connection
mongoose.connect("mongodb://localhost:27017/ecommerce", {
  useNewUrlParser: true,
  useUnifiedTopology: true
})
  .then(() => console.log("Connected to MongoDB"))
  .catch(err => {
    console.error("MongoDB connection error:", err);
    process.exit(1); // Exit if DB fails
  });

// Middleware to verify token
const authenticateToken = (req, res, next) => {
  const authHeader = req.headers["authorization"];
  const token = authHeader && authHeader.split(" ")[1];
  if (!token) {
    console.error("No token provided");
    return res.status(401).json({ message: "Authentication required" });
  }
  jwt.verify(token, JWT_SECRET, (err, user) => {
    if (err) {
      console.error("Token verification error:", err.message);
      return res.status(403).json({ message: "Invalid token" });
    }
    req.userId = user.userId;
    next();
  });
};

// Test route
app.get("/", (req, res) => {
  res.json({ message: "Server is running" });
});

// Products endpoint
app.get("/api/products", async (req, res) => {
  try {
    const products = await Product.find();
    res.json(products);
  } catch (err) {
    console.error("Products error:", err.message);
    res.status(500).json({ message: "Failed to fetch products" });
  }
});

// Register endpoint
app.post("/auth/register", async (req, res) => {
  const { email, name, phoneNumber, password } = req.body;
  if (!email || !name || !phoneNumber || !password) {
    console.error("Missing fields in register request:", req.body);
    return res.status(400).json({ message: "All fields are required" });
  }
  try {
    const existingUser = await User.findOne({ email });
    if (existingUser) {
      return res.status(400).json({ message: "Email already exists" });
    }
    const user = new User({ email, name, phoneNumber, password, role: "USER" });
    await user.save();
    const token = jwt.sign({ userId: user._id, role: user.role }, JWT_SECRET, { expiresIn: "1h" });
    res.status(200).json({ message: "Registration successful", token, role: user.role });
  } catch (err) {
    console.error("Registration error:", err.message);
    res.status(500).json({ message: "Server error" });
  }
});

// Login endpoint
app.post("/auth/login", async (req, res) => {
  const { email, password } = req.body;
  if (!email || !password) {
    console.error("Missing email or password in login request:", req.body);
    return res.status(400).json({ message: "Email and password are required" });
  }
  try {
    const user = await User.findOne({ email, password });
    if (!user) {
      console.error("Invalid credentials for email:", email);
      return res.status(401).json({ message: "Invalid credentials" });
    }
    const token = jwt.sign({ userId: user._id, role: user.role }, JWT_SECRET, { expiresIn: "1h" });
    res.json({ message: "Login successful", token, role: user.role });
  } catch (err) {
    console.error("Login error:", err.message);
    res.status(500).json({ message: "Server error" });
  }
});

// User info endpoint
app.get("/user/my-info", authenticateToken, async (req, res) => {
  try {
    const user = await User.findById(req.userId).select("-password");
    if (!user) {
      console.error("User not found for ID:", req.userId);
      return res.status(404).json({ message: "User not found" });
    }
    res.json({ user });
  } catch (err) {
    console.error("User info error:", err.message);
    res.status(500).json({ message: "Server error" });
  }
});

// Start server
app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});