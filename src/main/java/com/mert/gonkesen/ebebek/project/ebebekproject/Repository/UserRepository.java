package com.mert.gonkesen.ebebek.project.ebebekproject.Repository;

import com.mert.gonkesen.ebebek.project.ebebekproject.model.User;
import org.springframework.stereotype.Repository;

public interface UserRepository {
    User findByEmail(String email);
    void save(User user);
}
