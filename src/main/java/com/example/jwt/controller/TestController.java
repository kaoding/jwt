package com.example.jwt.controller;

import com.example.jwt.domain.Device;
import com.example.jwt.domain.Product;
import com.example.jwt.domain.Role;
import com.example.jwt.domain.User;
import com.example.jwt.repository.DeviceRepository;
import com.example.jwt.repository.ProductRepository;
import com.example.jwt.repository.RoleRepository;
import com.example.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * TestController
 *
 * @author lijiehua
 * @date 2018-06-11
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DeviceRepository deviceRepository;

    @PostMapping("/role/add")
    public User addRole(@RequestBody UserRole ur) {
        Optional<User> optionalUser = userRepository.findById(ur.getUserId());
        Optional<Role> optionalRole = roleRepository.findById(ur.getRoleId());
        User user = optionalUser.get();
        Role role = optionalRole.get();
        user.getRoles().add(role);
        return userRepository.save(user);
    }

    @PostMapping("/role/remove")
    public User removeRole(@RequestBody UserRole ur) {
        Optional<User> optionalUser = userRepository.findById(ur.getUserId());
        Optional<Role> optionalRole = roleRepository.findById(ur.getRoleId());
        User user = optionalUser.get();
        Role role = optionalRole.get();
        user.getRoles().remove(role);
        return userRepository.save(user);
    }

    @PostMapping("/device/add/{id}")
    public Device addDevice(@PathVariable("id") String id, @RequestBody Device device) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product product = optionalProduct.get();
        device.setProduct(product);
        return deviceRepository.save(device);
    }

    @PostMapping("/device/remove/{id}")
    public void removeDevice(@PathVariable("id") String id) {
        deviceRepository.deleteById(id);
    }
}
