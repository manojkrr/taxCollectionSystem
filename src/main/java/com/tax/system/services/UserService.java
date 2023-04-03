package com.tax.system.services;

import com.tax.system.entities.User;

public interface UserService {

    User registerUser(String username, String password);

    User loginUser(String username, String password);
}
