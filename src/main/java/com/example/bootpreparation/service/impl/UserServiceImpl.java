package com.example.bootpreparation.service.impl;

import com.example.bootpreparation.entity.User;
import com.example.bootpreparation.repository.UserRepository;
import com.example.bootpreparation.service.UserService;
import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findUser() {
        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        return userRepository
                .findAll()
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .get();
    }

    @Override
    public void update(User user) {
        User entity = findUser();
        if (user.getFirstName() != null && user.getFirstName().length() != 0) {
            entity.setFirstName(user.getFirstName());
        }
        if (user.getLastName() != null && user.getLastName().length() != 0) {
            entity.setLastName(user.getLastName());
        }
        if (user.getPassword() != null && user.getPassword().length() != 0) {
            entity.setPassword(user.getPassword());
        }
        userRepository.save(entity);
    }
}
