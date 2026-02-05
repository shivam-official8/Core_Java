package com.example.ecommerce.controller.pagecontroller;


import com.example.ecommerce.entity.Users;
import com.example.ecommerce.service.AuthService;
import com.example.ecommerce.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    // Home page (requires login)
    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        Users loggedInUser = (Users) session.getAttribute("user");
        if (loggedInUser == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", loggedInUser);
        return "home"; // home.jsp
    }

    // Show login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login.jsp
    }

    // Process login form
    @PostMapping("/login")
    public String login(@ModelAttribute Users user, HttpSession session, Model model) {
        Users existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            session.setAttribute("user", existingUser); // store user in session
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid username or password!");
            return "login";
        }
    }

    // Show signup page
    @GetMapping("/signup")
    public String showSignupPage(Model model) {
        model.addAttribute("user", new Users());
        return "signup"; // signup.jsp
    }

    // Process signup form
    @PostMapping("/signup")
    public String signup(@ModelAttribute Users user, HttpSession session, Model model) {
        if (userService.findByUsername(user.getUsername()) != null) {
            model.addAttribute("error", "Username already exists!");
            return "signup";
        }
        authService.register(user); // save user in DB
        session.setAttribute("user", user); // log user in after signup
        return "redirect:/home";
    }

    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // clear session
        return "redirect:/login";
    }
}
