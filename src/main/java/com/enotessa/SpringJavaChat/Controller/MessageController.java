package com.enotessa.SpringJavaChat.Controller;

import com.enotessa.SpringJavaChat.Entity.MessageEntity;
import com.enotessa.SpringJavaChat.Entity.MessageRepository;
import com.enotessa.SpringJavaChat.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;

    @ResponseBody
    @GetMapping("/returnFromChat")
    public ModelAndView returnFromChat() {
        ModelAndView mav = new ModelAndView("page");
        return mav;
    }

    @ResponseBody
    @RequestMapping("/chatPage")
    public ModelAndView natureChat() {
        ModelAndView mav = new ModelAndView("chat");
        mav.addObject("messages", messageRepository.findAll());
        System.out.println(mav);
        return mav;
    }

    @ResponseBody
    @RequestMapping("/sendMessage")
    public ModelAndView sendMessage(HttpServletRequest request, HttpSession session) {
        Date date = new Date();
        ModelAndView mav = new ModelAndView("chat");
        MessageEntity message = new MessageEntity();
        message.setUserName(session.getAttribute("login").toString());
        message.setMessage(request.getParameter("message"));
        message.setTime(date);
        this.messageRepository.save(message);
        mav.addObject("messages", messageRepository.findAll());
        System.out.println(mav);
        return mav;
    }
}
