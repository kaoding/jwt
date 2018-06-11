package com.example.jwt.config;


import com.example.jwt.security.JwtUser;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * SpringSecurityAuditorAware
 *
 * @author lijiehua
 * @date 2018-06-10
 */
@Configuration
@EnableJpaAuditing
public class AuditorAwareConfig implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.of("");
        }
        JwtUser jwtUser = authentication.getPrincipal() instanceof JwtUser ? ((JwtUser) authentication.getPrincipal()) : null;
        return Optional.of(jwtUser != null ? jwtUser.getUsername() : "");
    }
}
