package com.cloudit.project.serviceImpl;

import com.cloudit.project.JwtUtils.JwtUtilities;
import com.cloudit.project.model.CustomUserDetails;
import com.cloudit.project.model.User;
import com.cloudit.project.payload.Login;
import com.cloudit.project.Repository.UserRepository;
import com.cloudit.project.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImplementation implements UserService {
    final UserRepository userRepository;
    final AuthenticationManager authenticate;
    final JwtUtilities jwtUtilities;
    final PasswordEncoder passwordEncoder;
    @Override
    public Map<String,String> authenticate(Login login) {
        Authentication authentication= authenticate.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login.getUsername(),
                        login.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = userRepository.findByUsername(authentication.getName());
        //List<String> rolesNames = new ArrayList<>();
        //user.getRoles().forEach(r-> rolesNames.add(r.getRoleName()));
        String token = jwtUtilities.generateJwtToken((CustomUserDetails) authentication.getPrincipal());
        Map<String,String> map = new HashMap<>();
        map.put("Token",token);
        return map;
    }






}
