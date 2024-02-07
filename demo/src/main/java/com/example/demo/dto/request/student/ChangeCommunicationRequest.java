package com.example.demo.dto.request.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ChangeCommunicationRequest {

    private String email;
    private String phoneNumber;
    private String token;
}
