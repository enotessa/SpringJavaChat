package com.enotessa.SpringJavaChat.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController {


    @ResponseBody
    @GetMapping("/count")
    public ModelAndView count() {
        ModelAndView mav = new ModelAndView("calc");
        mav.addObject("message", "you have successfully registered");
        return mav;
    }
}
