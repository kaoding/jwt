package com.example.jwt.security.auth;

import com.example.jwt.domain.User;

/**
 * AuthService
 *
 * @author lijiehua
 * @date 2018-06-11
 */
public interface AuthService {

    /**
     * 用户注册
     *
     * @param user 用户信息
     * @return 操作结果
     */
    User register(User user);

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 操作结果
     */
    String login(String username, String password);

    /**
     * 刷新密钥
     *
     * @param oldToken 原密钥
     * @return 新密钥
     */
    String refreshToken(String oldToken);
}
