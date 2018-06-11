package com.example.jwt.repository;

import com.example.jwt.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * RoleRepository
 *
 * @author lijiehua
 * @date 2018-06-10
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    /**
     * 通过角色名查找角色
     *
     * @param name 角色名
     * @return 角色信息
     */
    Role findByName(String name);
}
