package com.cloudit.project.service;

import com.cloudit.project.payload.Login;

import java.util.Map;

public interface UserService {
    Map<String,String> authenticate(Login login);
}
