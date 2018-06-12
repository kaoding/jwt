package com.example.jwt.security.jwt;

import com.example.jwt.domain.Role;
import com.example.jwt.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

/**
 * JwtUserFactory
 *
 * @author lijiehua
 * @date 2018-06-11
 */
public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getUsername(),
                user.getPassword(),
                mapToGrantedRoles(user.getRoles())
        );
    }

    private static List<GrantedAuthority> mapToGrantedRoles(List<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
