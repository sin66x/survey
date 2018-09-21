package com.roozaneh.survey.service;

import com.roozaneh.survey.domain.User;

public interface UserService {
    public int save(User user);

    User findByUsername(String username);

    User createUser(String username, String password, String role);
}
