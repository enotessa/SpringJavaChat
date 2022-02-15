package com.enotessa.SpringJavaChat;

import com.enotessa.SpringJavaChat.Entity.UserEntity;
import com.enotessa.SpringJavaChat.Entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

// http://localhost:8080
@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @RequestMapping("/")
    public String home() {
        String html = "";
        html += "<ul>";
        html += " <li><a href='/testInsert'>Test Insert</a></li>";
        html += " <li><a href='/showAllUsers'>Show All Users</a></li>";
        html += " <li><a href='/showFindByRole'>Show All Role 'user'</a></li>";
        html += " <li><a href='/deleteAllUsers'>Delete All Users</a></li>";
        html += "</ul>";
        return html;
    }

    @ResponseBody
    @RequestMapping("/testInsert")
    public String testInsert() {
        UserEntity user = new UserEntity();
        user.setUserName("u1");
        user.setPassword("1");
        user.setRole("user");
        this.userRepository.save(user);
        return "Inserted: " + user;
    }

    @ResponseBody
    @RequestMapping("/showAllUsers")
    public String showAllUsers() {

        Iterable<UserEntity> users = this.userRepository.findAll();

        String html = "";
        for (UserEntity user : users) {
            html += user + "<br>";
        }

        return html;
    }

    @ResponseBody
    @RequestMapping("/showFindByRole")
    public String showFindByRole() {

        List<UserEntity> users = this.userRepository.findByRole("user");

        String html = "";
        for (UserEntity user : users) {
            html += user + "<br>";
        }

        return html;
    }

    @ResponseBody
    @RequestMapping("/deleteAllUsers")
    public String deleteAllUsers() {

        this.userRepository.deleteAll();
        return "Deleted!";
    }


}
