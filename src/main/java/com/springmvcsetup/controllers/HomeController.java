package com.springmvcsetup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("home_controller")
public class HomeController {
    @RequestMapping("/home")
    public String home(){
        return "index";
    }
}
