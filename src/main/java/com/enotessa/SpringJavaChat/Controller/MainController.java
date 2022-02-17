package com.enotessa.SpringJavaChat.Controller;

import com.enotessa.SpringJavaChat.Entity.UserEntity;
import com.enotessa.SpringJavaChat.Entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

// http://localhost:8080
@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @PostMapping("/addUser")
    public String addUser(HttpServletRequest request, HttpServletResponse response,
                          @RequestParam(value = "login", required = false) String login,
                          @RequestParam(value = "password", required = false) String password,
                          Model model) {
        UserEntity user = new UserEntity();
        user.setUserName(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));     //TODO SHA1()
        user.setRole(request.getParameter("user"));
        this.userRepository.save(user);

        model.addAttribute("message", "succeed");
        return "page.jsp";
    }

    @ResponseBody
    @RequestMapping("/showAllUsers")
    public String showAllUsers(HttpServletRequest request, HttpServletResponse response) {
/*
        Iterable<UserEntity> users = this.userRepository.findAll();

        String html = "";
        for (UserEntity user : users) {
            html += user + "<br>";
        }
 */
        return "";

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
