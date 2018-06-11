package com.example.jwt.repository;

import com.example.jwt.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ProductRepository
 *
 * @author lijiehua
 * @date 2018-06-11
 */
public interface ProductRepository extends JpaRepository<Product, String> {
}
