package com.ymj.webdemo.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertContactRequest {
    private String username;
    private String name;
    private String phoneNumber;
    private String email;
    private String avatar;
}
