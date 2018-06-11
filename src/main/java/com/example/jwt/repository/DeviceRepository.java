package com.example.jwt.repository;

import com.example.jwt.domain.Device;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DeviceRepository
 *
 * @author lijiehua
 * @date 2018-06-11
 */
public interface DeviceRepository extends JpaRepository<Device, String> {
}
