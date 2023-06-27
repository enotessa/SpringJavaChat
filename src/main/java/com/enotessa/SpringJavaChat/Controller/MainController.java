package com.enotessa.SpringJavaChat.Controller;

import com.enotessa.SpringJavaChat.Entity.MessageRepository;
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
import javax.servlet.http.HttpSession;

// http://localhost:8080
@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessageRepository messageRepository;

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

        if (this.userRepository.existsByUserName(request.getParameter("login"))){
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
    public ModelAndView signIn(HttpServletRequest request, HttpSession session) {
        ModelAndView mav;
        if (userRepository.existsByUserNameAndPassword(request.getParameter("login"), request.getParameter("password"))){
            mav = new ModelAndView("page");
            session.setAttribute("login",request.getParameter("login"));
        }
        else {
            mav = new ModelAndView("index");
            mav.addObject("message", "invalid login or password");
        }
        return mav;
    }

    @ResponseBody
    @RequestMapping("/calcPage")
    public ModelAndView calcPage() {
        ModelAndView mav = new ModelAndView("calc");
        System.out.println(mav);
        return mav;
    }

}
