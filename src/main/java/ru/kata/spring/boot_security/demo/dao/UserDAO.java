package ru.kata.spring.boot_security.demo.dao;


import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

public interface UserDAO {
    void saveUser(User user);

//    void updateUser(User user);
    void deleteUser(long id);

    List<User> getAllUsers();

    User findUserByEmail(String email);

    User getUser(long id);
}



