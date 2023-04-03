package com.tax.system.services.impl;

import com.tax.system.entities.User;
import com.tax.system.repositories.UserRepository;
import com.tax.system.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User loginUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
