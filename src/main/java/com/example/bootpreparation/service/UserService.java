package com.example.bootpreparation.service;

import com.example.bootpreparation.entity.User;
import java.util.List;

public interface UserService {
    User add(User user);

    List<User> findAll();

    void deleteById(Long id);

    User findUser();

    void update(User user);
}
