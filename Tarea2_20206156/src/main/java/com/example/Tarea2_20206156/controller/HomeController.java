package com.example.Tarea2_20206156.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
 @RequestMapping(value = "/", method = RequestMethod.GET)
    public String irAlMain() {
     return "redirect:/employee";
    }
    
}

