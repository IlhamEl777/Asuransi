package com.ilhamel.asuransi.repositories;

import com.ilhamel.asuransi.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}