package com.mahi.javapassion.productservice.command.api;

import com.mahi.javapassion.productservice.command.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
