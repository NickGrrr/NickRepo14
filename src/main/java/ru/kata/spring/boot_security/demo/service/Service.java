package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

public interface Service {
    void deleteUser(Integer id);
    void saveUser(User user);
    User getUser(Integer id);
    public User findUserByName(String username);
    public List<User> getAllUsers();
//    public User findUserByName(String username);
    public List<Role> getAllRoles();
    public Role getRole(Integer id);
    public Role findRoleByName(String username);
}
