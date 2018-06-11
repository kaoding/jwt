package com.example.jwt.controller;

import com.example.jwt.domain.Role;
import com.example.jwt.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RoleController
 *
 * @author lijiehua
 * @date 2018-06-10
 */
@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleRepository repository;

    @PostMapping
    public Role create(@RequestBody Role role) {
        return repository.save(role);
    }

    @GetMapping
    public List<Role> list() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Role get(@PathVariable("id") Long id) {
        if (repository.existsById(id)) {
            return repository.findById(id).get();
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException();
        }
    }
}
