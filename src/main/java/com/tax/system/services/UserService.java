package com.tax.system.services;

import com.tax.system.entities.User;

public interface UserService {

    User registerUser(User user);

    User loginUser(String username, String password);
}
