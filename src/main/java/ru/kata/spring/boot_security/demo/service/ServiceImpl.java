package ru.kata.spring.boot_security.demo.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.RoleDAO;
import ru.kata.spring.boot_security.demo.dao.UserDAO;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServiceImpl implements ru.kata.spring.boot_security.demo.service.Service, UserDetailsService{

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;


@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findUserByName(username);
        if(user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        }
        return user;
    }
//    public User findUserById(Integer userId) {
//        Optional<User> userFromDb = userDAO.findById(userId);
//        return userFromDb.orElse(new User());
//    }
//
//    public List<User> allUsers() {
//        return userDAO.findAll();
//    }
//
//    public boolean saveUser(User user) {
//        User userFromDB = userDAO.findByUsername(user.getUsername());
//
//        if (userFromDB != null) {
//            return false;
//        }
//
//        user.setRoles(Collections.singleton(new Role(1, "ROLE_USER")));
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userDAO.save(user);
//        return true;
//    }
//
//    public boolean deleteUser(Integer userId) {
//        if (userDAO.findById(userId).isPresent()) {
//            userDAO.deleteById(userId);
//            return true;
//        }
//        return false;
//    }
//
//    public List<User> usergtList(Long idMin) {
//        return em.createQuery("SELECT u FROM User u WHERE u.id > :paramId", User.class)
//                .setParameter("paramId", idMin).getResultList();}



    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
    @Override
    @Transactional
    public void saveUser(User user) {userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public User getUser(Integer id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void deleteUser(Integer id) {
        userDAO.deleteUser(id);
    }

    @Override
    public User findUserByName(String username) {
        return userDAO.findUserByName(username);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    @Override
    public Role getRole(Integer id) {
        return roleDAO.getRole(id);
    }

    @Override
    public Role findRoleByName(String name) {
        return roleDAO.findRoleByName(name);
    }



}
