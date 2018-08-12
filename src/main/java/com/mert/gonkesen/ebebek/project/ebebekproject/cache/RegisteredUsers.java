package com.mert.gonkesen.ebebek.project.ebebekproject.cache;

import com.mert.gonkesen.ebebek.project.ebebekproject.model.User;
import org.springframework.stereotype.Component;
import java.util.HashMap;

@Component
public class RegisteredUsers {
    private HashMap<String, User> userCache = new HashMap<String, User>();

    public boolean isUserRegistered(User user){
        if(userCache.get(user.getEmail()) != null)
            return true;

        return false;
    }

    public void saveUser(User user){
        userCache.put(user.getEmail(), user);
    }

    public HashMap<String, User> getUserCache() {
        return userCache;
    }
}
