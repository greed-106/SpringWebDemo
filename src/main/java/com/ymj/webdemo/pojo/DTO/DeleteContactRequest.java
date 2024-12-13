package com.ymj.webdemo.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteContactRequest {
    private String username;
    private Integer contactId;
}
