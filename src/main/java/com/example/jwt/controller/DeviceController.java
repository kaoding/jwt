package com.example.jwt.controller;

import com.example.jwt.domain.Device;
import com.example.jwt.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * DeviceController
 *
 * @author lijiehua
 * @date 2018-06-11
 */
@RestController
@RequestMapping("/api/devices")
@PreAuthorize("hasRole('USER')")
public class DeviceController {

    @Autowired
    private DeviceRepository repository;

    @PostMapping
    public Device create(@RequestBody Device device) {
        return repository.save(device);
    }

    @GetMapping
    public List<Device> list() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Device get(@PathVariable("id") String id) {
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
