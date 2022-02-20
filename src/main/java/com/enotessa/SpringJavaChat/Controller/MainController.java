package com.enotessa.SpringJavaChat.Controller;

import com.enotessa.SpringJavaChat.Entity.UserEntity;
import com.enotessa.SpringJavaChat.Entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8080
@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    @ResponseBody
    @PostMapping("/addUser")
    public ModelAndView addUser(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("index");

        if (userRepository.existsByUserName(request.getParameter("login"))){
            mav.addObject("message", "this user already exists");
        }
        else {
            UserEntity user = new UserEntity();
            user.setUserName(request.getParameter("login"));
            user.setPassword(request.getParameter("password"));     //TODO SHA1()
            user.setRole(request.getParameter("user"));
            this.userRepository.save(user);
            mav.addObject("message", "you have successfully registered");
        }
        return mav;
    }

    @ResponseBody
    @RequestMapping("/signIn")
    public ModelAndView signIn(HttpServletRequest request) {
        ModelAndView mav; //= new ModelAndView("index");
        if (userRepository.existsByUserNameAndPassword(request.getParameter("login"), request.getParameter("password"))){
            mav = new ModelAndView("page");
        }
        else {
            mav = new ModelAndView("index");
            mav.addObject("message", "invalid login or password");
        }

        return mav;
    }

    @ResponseBody
    @RequestMapping("/showFindByRole")
    public String showFindByRole(HttpServletRequest request, HttpServletResponse response) {
/*
        List<UserEntity> users = this.userRepository.findByRole("user");

        String html = "";
        for (UserEntity user : users) {
            html += user + "<br>";
        }

 */

        return "html";
    }

    @ResponseBody
    @RequestMapping("/deleteAllUsers")
    public String deleteAllUsers(HttpServletRequest request, HttpServletResponse response) {

        this.userRepository.deleteAll();
        return "Deleted!";
    }

}
