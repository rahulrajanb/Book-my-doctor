package com.TekPyramid.BookMyDoctor.Service;

import com.TekPyramid.BookMyDoctor.DTO.UserDto;
import com.TekPyramid.BookMyDoctor.Entity.User;

public interface UserService {
    UserDto signUp(UserDto userDto); // returns saved user info
    boolean login(String email, String password);
}
