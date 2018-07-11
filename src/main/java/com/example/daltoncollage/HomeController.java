package com.example.daltoncollage;


import com.example.daltoncollage.model.Department;
import com.example.daltoncollage.model.Login;
import com.example.daltoncollage.model.Major;
import com.example.daltoncollage.repository.DepartmentRepository;
import com.example.daltoncollage.repository.LoginRepository;
import com.example.daltoncollage.repository.MajorRepository;
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

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    MajorRepository majorRepository;


//this will lead to main page
    @RequestMapping("/")
    public String home(Model model) {
        //model.addAttribute("login", loginRepository.findAll());
        return "index";
    }
// here we create a new login
    @GetMapping("/signup")
    public String signUpForm(Model model) {
        model.addAttribute("login", new Login());
        return "signup";
    }

    @GetMapping("/addepartment")
    public String adminAdd(Model model) {
        model.addAttribute("addDept", new Department());
        return "addepartment";
    }

    // GET MAJOR
    @GetMapping("/addMajor")
    public String addMajor(Model model){
        model.addAttribute("options", departmentRepository.findAll());
        model.addAttribute("addMajor", new Major());
        return "addMajor";
    }



    @PostMapping("/processSignUp")
    public String processSignUp(@ModelAttribute("login") Login login){

        loginRepository.save(login);
        return "redirect:/";
    }

    @PostMapping("/processdepartment")
    public String processdept(@ModelAttribute("department") Department department){
        departmentRepository.save(department);
        return "redirect:/addMajor";
    }

    @PostMapping("/processMajor")
    public String processdept(@ModelAttribute("major") Major major){
        majorRepository.save(major);
        return "test";
    }



    @GetMapping("/login")
    public String loginform(Model model) {
        model.addAttribute("log", new Login());
        return "loginpage";
    }


    @PostMapping("/processlogin")
    public String login(HttpServletRequest request, Model model) {
        String page="/login";
        String username= request.getParameter("username");
        String pass=request.getParameter("password");
        String user_type=request.getParameter("user_type");

        long count=loginRepository.countByUsernameAndPassword(username,pass);

        if ((count>0) && (user_type.equals("Student"))){
        page =  "StudentPage";
        }
        else if ((count>0) && (user_type.equals("Instructor"))){
            page =  "instructorpage";
        }
        else{
             page="redirect:/login";
         }

        return page;
    }

    @PostMapping("/processLogin")
    public String showCourses() {
        return "index";
    }
}
