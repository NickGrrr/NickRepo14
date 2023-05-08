package ru.kata.spring.boot_security.demo.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.Service;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private Service service;

    @GetMapping(value = "")
    public String showUsers (Model model) {

        model.addAttribute("users", service.getAllUsers());
        return "users";
    }

    @GetMapping(value = "/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "user-info";
    }

    @PostMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {

        service.saveUser(user);

        return "redirect:/admin";
    }

    @GetMapping(value = "/updateUser")
    public String updateUser(@RequestParam("userId") Integer id, Model model) {
        User user = service.getUser(id);
        model.addAttribute("user", user);

        return "user-info";
    }

    @GetMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam("userId") Integer id) {

        service.deleteUser(id);

        return "redirect:/admin";
    }

}
