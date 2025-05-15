package com.TekPyramid.BookMyDoctor.Controller;

import com.TekPyramid.BookMyDoctor.DTO.UserDto;
import com.TekPyramid.BookMyDoctor.Service.UserService;
import com.TekPyramid.BookMyDoctor.DTO.LoginRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // 1. USER SIGNUP
    @PostMapping("/signup")
    public String signUp(@RequestBody UserDto userDto) {
        UserDto createdUser = userService.signUp(userDto);
        return "User Added Successfully";
    }

    // 2. USER LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        boolean isValid = userService.login(loginRequestDTO.getEmail(), loginRequestDTO.getPassword());
        if (isValid) {
            return ResponseEntity.ok().body(Map.of("message", "Login Successful"));
        } else {
            return ResponseEntity.status(401).body(Map.of("message", "Invalid input"));
        }
    }
}
