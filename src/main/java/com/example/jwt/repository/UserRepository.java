package com.example.jwt.repository;

import com.example.jwt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 *
 * @author lijiehua
 * @date 2018-06-10
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 通过用户名查找用户
     *
     * @param username 用户名
     * @return 用户信息
     */
    User findByUsername(String username);
}
