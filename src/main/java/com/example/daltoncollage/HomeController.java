package com.example.daltoncollage;


import com.example.daltoncollage.model.*;
import com.example.daltoncollage.repository.*;
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


    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    ClassRepository classRepository;
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
        model.addAttribute("dept", departmentRepository.findAll());
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
    // add subject
    @GetMapping("/addsubject")
    public String addSubject(Model model){
        model.addAttribute("options", majorRepository.findAll());
        model.addAttribute("addsub", new Subject());
        return "addsubject";
        }

        @GetMapping("/addcourse")
        public String addCourse(Model model){
        model.addAttribute("options", subjectRepository.findAll());
        model.addAttribute("addcourse", new Course());
        return "addcourse";
        }

/// addding class room

        @GetMapping("/addclassroom")
        public String addclassRoom(Model model){
        model.addAttribute("classroom", new Classroom());
        return "addclassroom";
        }

    @GetMapping("/addinstructor")
    public String addInst(Model model){
        model.addAttribute("options", departmentRepository.findAll());
        model.addAttribute("instructor", new Instructor());
        return "addInstructor";
    }

    @GetMapping("/addcourseclass")
    public String addcourseclass(Model model){
        model.addAttribute("ins", instructorRepository.findAll());
        model.addAttribute("cou", courseRepository.findAll());
        model.addAttribute("room", classroomRepository.findAll());
        model.addAttribute("addclass", new CourseClass());
        return "addcourseclass";
    }

    @PostMapping("/processSignUp")
    public String processSignUp(@ModelAttribute("login") Login login){

        loginRepository.save(login);
        return "redirect:/";
    }

    @PostMapping("/processdepartment")
    public String processdept(@ModelAttribute("department") Department department){
        departmentRepository.save(department);
        return "redirect:/addepartment";
    }

    @PostMapping("/processMajor")
    public String processdept(@ModelAttribute("major") Major major){
        majorRepository.save(major);
        return "redirect:/addMajor";
    }

    @PostMapping("/processSubject")
    public String processSub(@ModelAttribute("subject")Subject subject){
         subjectRepository.save(subject);
        return "redirect:/addcourse";
    }
    @PostMapping("/processCourse")
    public String processCourse(@ModelAttribute("course") Course course){
        courseRepository.save(course);
        return "addcourseclass";
    }
    @PostMapping("/processClassroom")
    public String processClassroom(@ModelAttribute("classroom") Classroom classroom){
        classroomRepository.save(classroom);
        return "index";
    }

    @PostMapping("/processinstructor")
    public String processIns(@ModelAttribute("instructor") Instructor instructor){
        instructorRepository.save(instructor);
        return "index";
    }


    @GetMapping("/login")
    public String loginform(Model model) {
        model.addAttribute("log", new Login());
        return "loginpage";
    }

    @GetMapping("/showallcourse")
    public String ShowAll(Model model) {
        model.addAttribute("ins", instructorRepository.findAll());
        model.addAttribute("course", courseRepository.findAll());
        model.addAttribute("room", classroomRepository.findAll());
        model.addAttribute("cou", classRepository.findAll());
        return "ShowAllCourse";
    }

    @PostMapping("/processclass")
    public String processCourse(@ModelAttribute("courseclass") CourseClass courseClass) {
        classRepository.save(courseClass);
        return "index";
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
