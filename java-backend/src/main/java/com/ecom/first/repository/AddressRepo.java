package com.ecom.first.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.first.entity.Address;

public interface AddressRepo extends JpaRepository<Address,Long>{

}
