package com.mert.gonkesen.ebebek.project.ebebekproject.service;

import com.mert.gonkesen.ebebek.project.ebebekproject.model.User;

public interface UserService {
    User findByEmail(String email);
    void saveUser(User user);
}
