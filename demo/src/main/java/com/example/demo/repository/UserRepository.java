package com.example.demo.repository;

import java.util.List;
import com.example.demo.model.User;

public interface UserRepository {

    void addUser(User user);

    User getUser(Long id);

    List<User> getAllUsers();

    void removeUser(Long id);

    void updateUser(User newUser);
}
