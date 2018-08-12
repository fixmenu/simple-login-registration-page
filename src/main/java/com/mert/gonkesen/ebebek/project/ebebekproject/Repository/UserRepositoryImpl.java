package com.mert.gonkesen.ebebek.project.ebebekproject.Repository;

import com.mert.gonkesen.ebebek.project.ebebekproject.cache.RegisteredUsers;
import com.mert.gonkesen.ebebek.project.ebebekproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    RegisteredUsers registeredUsers;

    @Override
    public User findByEmail(String email) {
        return registeredUsers.getUserCache().get(email);
    }

    @Override
    public void save(User user) {
        if(!registeredUsers.isUserRegistered(user))
            registeredUsers.saveUser(user);
    }
}
