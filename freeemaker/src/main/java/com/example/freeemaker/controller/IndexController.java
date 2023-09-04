package com.example.freeemaker.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class IndexController {

    public IndexController() {
    }

    @RequestMapping({"/"})
    @ResponseBody
    public String index() {
        return "Welcome to YCB";
    }

    @RequestMapping({"/templating"})
    public String templating(@RequestParam String name, Model model) {
        System.out.println("123");
        model.addAttribute("name", name);
        return "index";
    }
}
