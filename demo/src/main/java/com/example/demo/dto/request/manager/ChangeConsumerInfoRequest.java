package com.example.demo.dto.request.manager;

import com.example.demo.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ChangeConsumerInfoRequest {

    private String token;
    private String tc;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Role role;
    private String password;
    private String userId;

}
