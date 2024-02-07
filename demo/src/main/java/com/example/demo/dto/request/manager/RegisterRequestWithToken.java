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
public class RegisterRequestWithToken {

    private String token;
    private String name;
    private String lastName;
    private String email;

    private String password;
    private String phoneNumber;
    private Role role;
}
