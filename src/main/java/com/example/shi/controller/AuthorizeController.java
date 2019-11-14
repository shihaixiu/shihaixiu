package com.example.shi.controller;

import com.example.shi.dto.AccessTokenDto;
import com.example.shi.dto.GithubUserDto;
import com.example.shi.provide.GitHubProvide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired
    private GitHubProvide gitHubProvide;
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state) {
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDto.setState(state);
        accessTokenDto.setClient_id("Iv1.25fb6fefcf73bdbc");
        accessTokenDto.setClient_secret("4adca18761b0226ff92e9ee39af227ff0c896bdc");
        String accessToken = gitHubProvide.getAccessToken(accessTokenDto);
        GithubUserDto user=gitHubProvide.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}

