package com.example.Development.ani_List.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Development.ani_List.domains.Anime;
import com.example.Development.ani_List.domains.AnimeStatus;
import com.example.Development.ani_List.dtos.AnimeDTO;
import com.example.Development.ani_List.repositories.AnimeRepository;

@Service
public class AnimeService {

    @Autowired
    private AnimeRepository animeRepository;
    
    public Anime addAnime(AnimeDTO dto) {
         // Map all Data -> Entity
        Anime entry = new Anime();
        entry.setTitle(dto.getTitle());
        entry.setGenre(dto.getGenre());
        entry.setPriority(dto.getPriority());
        entry.setStatus(AnimeStatus.NOT_STARTED);

        // Save to DB
        return animeRepository.save(entry);
    }
}
