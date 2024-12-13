package com.ymj.webdemo.pojo.DTO;

import com.ymj.webdemo.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
    private String username;
    private String password;

    public User getUser() {
        return new User(username, password);
    }
}