package com.project.m10app.service.impl;

import com.project.m10app.model.User;
import com.project.m10app.service.UserService;

import java.util.List;

public interface UserServiceImpl {

    List<User> getAllUsers();
    User getUserById(long id);
    User saveUser(User user);
}
