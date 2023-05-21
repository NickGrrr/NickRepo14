package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

public interface Service {
    List<Role> getAllRoles();

    Role getRole(String userRole);

    Role getRoleById(Long id);

    void addRole(Role role);

    void saveUser(User user);



    void deleteUser(long id);

    List<User> getAllUsers();

    User findUserByEmail(String email);

    User getUser(long id);

}

