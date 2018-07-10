package com.example.daltoncollage;


import com.example.daltoncollage.model.Login;
import com.example.daltoncollage.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
public class HomeController {

    @Autowired
    LoginRepository loginRepository;


    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("login", loginRepository.findAll());
        return "index";
    }

    @GetMapping("/signup")
    public String signUpForm(Model model) {
        model.addAttribute("login", new Login());
        return "signup";
    }


    @PostMapping("/processSignUp")
    public String processSignUp(@ModelAttribute("login") Login login){

        loginRepository.save(login);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginform(Model model) {
        model.addAttribute("log", new Login());
        return "loginpage";
    }


    @PostMapping("/processlogin")
    public String login(HttpServletRequest request, Model model) {
        String page="loginpage";


        String username= request.getParameter("username");
        String pass=request.getParameter("password");

        long count=loginRepository.countByUsernameAndPassword(username,pass);
         if (count>0){
        page =  "test";
        }

        return page;
    }

    @PostMapping("/processLogin")
    public String showCourses() {
        return "index";
    }
}
