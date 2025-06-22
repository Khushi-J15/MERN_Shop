import mongoose from "mongoose";

const productSchema = new mongoose.Schema({
  id: String,
  image: String,
  name: String,
  rating: {
    stars: Number,
    count: Number,
  },
  priceCents: Number,
  keywords: [String],
});

const Product = mongoose.model("Product", productSchema);
export default Product;
