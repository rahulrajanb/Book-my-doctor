package com.TekPyramid.BookMyDoctor.Repository;

import com.TekPyramid.BookMyDoctor.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findByUserName(String userName);
}
