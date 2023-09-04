package com.example.freeemaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FreeMarkerController {
    @RequestMapping("/simple")
    public String simple(){
        return "simple";
    }

    @RequestMapping({"/templating"})
    public String templating(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
}