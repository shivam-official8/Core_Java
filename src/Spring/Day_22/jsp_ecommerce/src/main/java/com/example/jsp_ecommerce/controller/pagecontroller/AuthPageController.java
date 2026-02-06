package com.example.jsp_ecommerce.controller.pagecontroller;

import com.example.jsp_ecommerce.entity.Users;
import com.example.jsp_ecommerce.repository.UserRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AuthPageController {

    private PasswordEncoder passwordEncoder;
    private UserRepo repo;



    public AuthPageController(UserRepo repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
//    @ResponseBody
    public String loginUser(Model model, HttpSession session, @RequestParam String username, @RequestParam String password){

        Users user = repo.findByUsername(username);
        ModelAndView view = new ModelAndView("home");
        System.out.println(user.toString());
        System.out.println(passwordEncoder.matches(password, user.getPassword()) +"   ...... here");
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            model.addAttribute("loginerror", false);
            System.out.println("inside if");
            session.setAttribute("user", user);
//            UsernamePasswordAuthenticationToken auth =
//                    new UsernamePasswordAuthenticationToken(
//                            user.getUsername(),
//                            null,
//                            List.of(new SimpleGrantedAuthority("ROLE_"+user.getRole()))
//                    );
//            SecurityContextHolder.getContext().setAuthentication(auth);
            return "redirect:/home12";
        }

        model.addAttribute("loginerror", true);
//        view.setViewName("login");
        return "redirect:/login122";
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @GetMapping("/")

    public String home(HttpSession session) {
        if(session.getAttribute("user")==null)
        return "login12";
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }

}
