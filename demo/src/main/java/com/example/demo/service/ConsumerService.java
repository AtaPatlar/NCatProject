package com.example.demo.service;

import com.example.demo.dto.request.LoginRequest;
import com.example.demo.dto.request.RegisterRequest;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.dto.response.BaseTokenResponse;
import com.example.demo.entity.Consumer;
import com.example.demo.exception.custom.EmailAlreadyException;
import com.example.demo.exception.custom.EmailNotValidException;
import com.example.demo.exception.custom.PasswordLoginException;
import com.example.demo.repository.ConsumerRepository;
import com.example.demo.utility.HashPassword;
import com.example.demo.utility.JwtManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumerService {

    private final ConsumerRepository consumerRepository;
    private final JwtManager  jwtManager;

    public ConsumerService(ConsumerRepository consumerRepository, JwtManager jwtManager) {
        this.consumerRepository = consumerRepository;
        this.jwtManager = jwtManager;
    }


    public BaseResponse register(RegisterRequest registerRequest) {

        Optional<Consumer> consumers=consumerRepository.findOptionalByEmail(registerRequest.getEmail());

        if(consumers.isPresent()){
            throw new EmailAlreadyException();
        }
        if (!registerRequest.getEmail().contains("@")) {
            throw new EmailNotValidException();

        }

        Consumer consumer= Consumer.builder()
                .email(registerRequest.getEmail())
                .name(registerRequest.getName())
                .lastName(registerRequest.getLastName())
                .role(registerRequest.getRole())
                .phoneNumber(registerRequest.getPhoneNumber())
                .password(HashPassword.encrypt(registerRequest.getPassword()))
                .build();

        consumerRepository.save(consumer);

        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setMessage("Kayıt Yapıldı");
        baseResponse.setStatusCode(200);

        return baseResponse;
    }
    public BaseTokenResponse login(LoginRequest loginRequest) {

        if(!consumerRepository.existsByEmail(loginRequest.getEmail())){
            throw new EmailNotValidException();
        }
    Optional<Consumer> consumer=consumerRepository.findOptionalByEmail(loginRequest.getEmail());

        if (!HashPassword.encrypt(loginRequest.getPassword()).equals(consumer.get().getPassword())){
            throw new PasswordLoginException();
        }
        Optional<String> token= jwtManager.createToken(consumer.get().getId(),consumer.get().getEmail());
        return BaseTokenResponse.builder()
                .message("Giriş yapıldı")
                .statusCode("200")
                .token(token.get())
                .build();

    }
    public Optional<Consumer> findById(String id){
       return consumerRepository.findById(id);
    }

    public boolean existsById(String id) {

        return consumerRepository.existsById(id);
    }

    public List<Consumer> findAll() {
        return consumerRepository.findAllByStudent();
    }

    public Optional<Consumer> findOptionalByEmail(String email) {
        return consumerRepository.findOptionalByEmail(email);
    }

    public void changeInfo(Consumer consumer1) {

        consumerRepository.save(consumer1);
    }

    public void saveConsumer(Consumer consumer1) {
        consumerRepository.save(consumer1);
    }

    public List<Consumer> findAllStudent() {
        return consumerRepository.findAllByStudent();
    }
}
