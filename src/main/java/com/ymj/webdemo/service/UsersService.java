package com.ymj.webdemo.service;

import com.ymj.webdemo.pojo.User;

public interface UsersService {
    User selectUserByUsername(String username);

    void insertUser(User user);

    void deleteUser(String username);

    void updateUser(User user);

    void verifyLogin(User user);

    void verifyRegister(User user);

    void verifyUsername(String username);

    boolean isUsernameExist(String username);
}
