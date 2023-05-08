package ru.kata.spring.boot_security.demo.dao;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.Collections;
import java.util.List;
@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public List<User> getAllUsers(){
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public boolean saveUser(User user) {
//        User userFromDB = findUserByName(user.getUsername());
//
//        if (userFromDB != null) {
//            return false;
//        }

        user.setRoles(Collections.singleton(new Role(1, "ROLE_USER")));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        entityManager.merge(user);
        return true;
    }

    @Override
    public User getUser(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(Integer id) {

        Query query = entityManager.createQuery("delete from User where id =:userId");
        query.setParameter("userId", id);
        query.executeUpdate();

    }
    @Override
    public User findUserByName(String username) {
        return entityManager
                .createQuery("select u from User u left join fetch u.roles where u.username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();

    }
}
