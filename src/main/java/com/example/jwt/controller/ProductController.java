package com.example.jwt.controller;

import com.example.jwt.domain.Product;
import com.example.jwt.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ProductController
 *
 * @author lijiehua
 * @date 2018-06-11
 */
@RestController
@RequestMapping("/api/products")
@PreAuthorize("hasRole('ADMIN')")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @PostMapping
    public Product create(@RequestBody Product product) {
        return repository.save(product);
    }

    @GetMapping
    public List<Product> list() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable("id") String id) {
        if (repository.existsById(id)) {
            return repository.findById(id).get();
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException();
        }
    }
}
