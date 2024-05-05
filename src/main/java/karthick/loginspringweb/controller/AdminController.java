package karthick.loginspringweb.controller;

import java.util.List;

import karthick.loginspringweb.model.UsersModel;
import karthick.loginspringweb.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import karthick.loginspringweb.model.AdminModel;
import karthick.loginspringweb.service.AdminService;

@Controller
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping("/admin")
    public String viewHomePage(Model model) {

        List<AdminModel> liststudent = service.listAll();
        model.addAttribute("liststudent", liststudent);
        System.out.print("Get / ");
        return "index";
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("student", new AdminModel());
        return "new";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") AdminModel std) {
        service.save(std);
        return "redirect:/admin";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        AdminModel std = service.get(id);
        mav.addObject("student", std);
        return mav;

    }

    @RequestMapping("/delete/{id}")
    public String deletestudent(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/admin";
    }

    @GetMapping("/adminlogin")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new UsersModel());
        return "login_page1";
    }
UsersService usersService;
    @PostMapping("/adminlogin")
    public String register(@ModelAttribute UsersModel usersModel, Model model) {
        System.out.println("login request: " + usersModel);

        if (usersModel.getUsername().equals("admin")&&usersModel.getPassword().equals("1205")) {

            return "redirect:/admin";
        } else {

            return "error_page";
        }
    }
}