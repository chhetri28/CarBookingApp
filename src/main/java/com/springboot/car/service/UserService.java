package com.springboot.car.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.springboot.car.model.User;

@Service
public class UserService {
	private Map<String, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getUserName(), user);
    }

    public User getUserByUsername(String username) {
        return users.get(username);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }
}
