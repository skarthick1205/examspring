package karthick.loginspringweb.controller;

import karthick.loginspringweb.model.AdminModel;
import karthick.loginspringweb.model.ApplyModel;
import karthick.loginspringweb.model.UsersModel;
import karthick.loginspringweb.repository.UsersRepository;
import karthick.loginspringweb.service.AdminService;
import karthick.loginspringweb.service.EmailService;
import karthick.loginspringweb.service.UsersService;
import karthick.loginspringweb.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.tags.Param;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private AdminService services;
    @Autowired
    private ApplyService applyService;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private EmailService emailService;
 String emailaccount;
    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new UsersModel());
        return "register_page";
    }

    @GetMapping("/loginn")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new UsersModel());
        return "login_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UsersModel usersModel) {
        System.out.println("register request: " + usersModel);
        UsersModel registeredUser = usersService.registerUser(usersModel.getUsername(), usersModel.getPassword(), usersModel.getEmailid());
System.out.println("emailid: "+registeredUser.getEmailid());
        System.out.println("emailid: "+registeredUser.getUsername());
        System.out.println("emailid: "+registeredUser.getId());

        emailService.sendEmail(registeredUser.getEmailid(),"Account Registration","Your account has been successfully registered@ExamController");

emailaccount=registeredUser.getEmailid();
        return registeredUser == null ? "error_page" : "redirect:/loginn";

    }

    @PostMapping("/loginn")
    public String register(@ModelAttribute UsersModel usersModel, Model model) {
        System.out.println("login request: " + usersModel);
        UsersModel authenticated = usersService.authenticate(usersModel.getUsername(), usersModel.getPassword());
        if (authenticated != null) {
            model.addAttribute("userLogin", authenticated.getUsername());
            model.addAttribute("userLoginn", authenticated.getId());

            List<AdminModel> liststudent = services.listAll();
            model.addAttribute("liststudent", liststudent);
            return "personal_page";
        } else {

            return "error_page";
        }

    }

    @GetMapping("/apply")
    public String getapplyPage(Model model) {
        model.addAttribute("applyRequest", new ApplyModel());
        return "application_page";
    }

    @PostMapping("/apply")
    public String apply(@ModelAttribute ApplyModel applyModel, Model model) {
        System.out.println("apply request: " + applyModel);

        ApplyModel appliedUser = applyService.applyUser(applyModel.getName(), applyModel.getDob(), applyModel.getGender(), applyModel.getAddress(), applyModel.getExamcode(), applyModel.getCentre(), applyModel.getLanguage());
        model.addAttribute("aname", appliedUser.getName());
        model.addAttribute("adob", appliedUser.getDob());
        model.addAttribute("agender", appliedUser.getGender());
        model.addAttribute("aaddress", appliedUser.getAddress());
        model.addAttribute("aexamcode", appliedUser.getExamcode());
        model.addAttribute("acentre", appliedUser.getCentre());
        model.addAttribute("alanguage", appliedUser.getLanguage());

        return appliedUser == null ? "error_page" : "hallticket_page";


    }



    @RequestMapping("/edits/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
        int id1=id;
        ModelAndView mav = new ModelAndView("register1");

        System.out.println("id ="+id1);

        emailService.sendEmail(emailaccount,"Account Upgradation/Deletion","The account is successfully upgraded@ExamController");
        UsersModel std = usersService.get(id);

         usersService.delete(id);
        return mav;

    }



}









