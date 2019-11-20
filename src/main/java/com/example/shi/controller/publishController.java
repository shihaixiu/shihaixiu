package com.example.shi.controller;
import com.example.shi.mapper.UserMapper;
import com.example.shi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class publishController {
    @GetMapping("/publish")
    public String publish(){
        return  "publish";
    }
}