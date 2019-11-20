package com.example.shi.dto;

import lombok.Data;

@Data
public class GithubUserDto {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
