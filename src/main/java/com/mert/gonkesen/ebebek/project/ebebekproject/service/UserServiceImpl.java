package com.mert.gonkesen.ebebek.project.ebebekproject.service;

import com.mert.gonkesen.ebebek.project.ebebekproject.Repository.UserRepository;
import com.mert.gonkesen.ebebek.project.ebebekproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    @Autowired
    UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(PASSWORD_ENCODER.encode(user.getPassword()));
        userRepository.save(user);
    }
}
