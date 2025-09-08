package com.example.Development.ani_List.dtos;


import com.example.Development.ani_List.domains.AnimeStatus;

import lombok.Data;

@Data
public class AnimeDTO {

    private String title;
    private String genre;
    private AnimeStatus status;
    private int priority;
    
}
