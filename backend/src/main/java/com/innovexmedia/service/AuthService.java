package com.innovexmedia.service;

import com.innovexmedia.model.User;

public interface AuthService {
    User register(String username, String email, String password);
    String login(String username, String password);
}
