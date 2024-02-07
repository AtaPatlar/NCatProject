package com.example.demo.controller;

import com.example.demo.dto.request.LoginRequest;
import com.example.demo.dto.request.RegisterRequest;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.dto.response.BaseTokenResponse;
import com.example.demo.service.ConsumerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class ConsumerController {

    private final ConsumerService consumerService;

    public ConsumerController(ConsumerService usersService) {
        this.consumerService = usersService;
    }


    @PostMapping("/register")
    public ResponseEntity<BaseResponse> register(@RequestBody RegisterRequest registerRequest){

        return ResponseEntity.ok(consumerService.register(registerRequest));

    }
    @PostMapping("/login")
    public ResponseEntity<BaseTokenResponse> login (@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok((consumerService.login(loginRequest)));
    }


}
