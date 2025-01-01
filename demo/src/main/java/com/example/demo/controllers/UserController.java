package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public static ArrayList<User> users = new ArrayList<>();
    public static boolean bl = true;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        if (user.getFirstName().isEmpty() || user.getLastName().isEmpty()) { return "/users"; }
        userService.addUser(user);
        return "redirect:/users";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam("id") Long id, @ModelAttribute("user") User user) {
        if (id < 1) {
            return "redirect:/users";
        }
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @PostMapping("/remove")
    public String removeUser(@ModelAttribute("id") Long id) {
        if (id < 1) {
            return "redirect:/users";
        }
        userService.removeUser(id);
        return "redirect:/users";
    }
}
