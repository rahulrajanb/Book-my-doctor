package com.TekPyramid.BookMyDoctor.Service;

import com.TekPyramid.BookMyDoctor.DTO.UserDto;
import com.TekPyramid.BookMyDoctor.Entity.User;
import com.TekPyramid.BookMyDoctor.Repository.UserRepository;
import com.TekPyramid.BookMyDoctor.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private User convertToEntity(UserDto dto) {
        return User.builder()
                .userName(dto.getUserName())
                .age(dto.getAge())
                .city(dto.getCity())
                .State(dto.getState())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .gender(dto.getGender())
                .mobileNumber(dto.getMobileNumber())
                .build();
    }

    private UserDto convertToDto(User user) {
        UserDto dto = new UserDto();
        dto.setUserName(user.getUserName());
        dto.setAge(user.getAge());
        dto.setCity(user.getCity());
        dto.setState(user.getState());
        dto.setEmail(user.getEmail());
        dto.setGender(user.getGender());
        dto.setMobileNumber(user.getMobileNumber());
        // appointments can be mapped if needed
        return dto;
    }

    @Override
    public UserDto signUp(UserDto userDto) {
        // Optional: Add checks for email or mobile duplication here
        User user = convertToEntity(userDto);
        User saved = userRepository.save(user);
        return convertToDto(saved);
    }

    @Override
    public boolean login(String email, String password) {
        User user = userRepository.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }
}
