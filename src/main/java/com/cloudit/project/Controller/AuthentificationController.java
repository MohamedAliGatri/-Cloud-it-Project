package com.cloudit.project.Controller;

import com.cloudit.project.payload.Login;
import com.cloudit.project.serviceImpl.UserServiceImplementation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/login")
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthentificationController {
    final UserServiceImplementation userServiceImplementation;
    @PostMapping
    public Map<String, String> login(@RequestBody Login login){
        return userServiceImplementation.authenticate(login);
    }
}
