package com.project.m10app.service;

import com.project.m10app.model.User;
import com.project.m10app.repository.UserRepository;
import com.project.m10app.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserServiceImpl {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
