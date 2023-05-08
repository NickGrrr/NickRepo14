package ru.kata.spring.boot_security.demo.dao;








import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

public interface UserDAO{
//    @Query("Select u from User u left join fetch u.roles where u.username=:username")
    public List <User> getAllUsers();
    public boolean saveUser(User user);
    public User getUser(Integer id);

    public void deleteUser(Integer id);

    public User findUserByName(String username);

}
