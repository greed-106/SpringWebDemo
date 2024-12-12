package com.ymj.webdemo.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateContactRequest {
    private String username;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
}
