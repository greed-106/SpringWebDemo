package com.ymj.webdemo.service.impl;

import com.ymj.webdemo.exception.DuplicateUsernameException;
import com.ymj.webdemo.exception.NotFoundException;
import com.ymj.webdemo.exception.WrongUsernameOrPasswordException;
import com.ymj.webdemo.mapper.UsersMapper;
import com.ymj.webdemo.pojo.User;
import com.ymj.webdemo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersMapper usersMapper;

    @Override
    public User selectUserByUsername(String username) {
        if(username == null) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        return usersMapper.selectUserByUsername(username);
    }

    @Override
    public void insertUser(User user) {
        if(user.getUsername() == null || user.getPassword() == null) {
            throw new IllegalArgumentException("Username or password cannot be empty");
        }
        usersMapper.insertUser(user);
    }

    @Override
    public void deleteUser(String username) {
        usersMapper.deleteUser(username);
    }

    @Override
    public void updateUser(User user) {
        User validUser = selectUserByUsername(user.getUsername());
        if(validUser == null) {
            throw new NotFoundException("User does not exist");
        }
        usersMapper.updateUser(user);
    }

    @Override
    public void verifyLogin(User user) {
        User validUser = usersMapper.selectUserByUsernameAndPassword(user);
        if(validUser == null) {
            throw new WrongUsernameOrPasswordException("Wrong username or password");
        }
    }

    @Override
    public void verifyRegister(User user) {
        if(isUsernameExist(user.getUsername())) {
            throw new DuplicateUsernameException("Username already exists");
        }
    }

    @Override
    public void verifyUsername(String username) {
        if(!isUsernameExist(username)) {
            throw new NotFoundException("User does not exist");
        }
    }

    @Override
    public boolean isUsernameExist(String username) {
        User user = usersMapper.selectUserByUsername(username);
        return user != null;
    }
}
