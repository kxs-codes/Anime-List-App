package com.example.Development.ani_List.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Development.ani_List.domains.Anime;
import com.example.Development.ani_List.dtos.AnimeDTO;
import com.example.Development.ani_List.dtos.UpdateAnimeDTO;
import com.example.Development.ani_List.repositories.AnimeRepository;
import com.example.Development.ani_List.services.AnimeService;

@RestController
@RequestMapping("api/anime")
public class AnimeController {

    @Autowired
    private AnimeRepository animeRepository;
    
    @Autowired
    private AnimeService animeService;

    @PostMapping("/create")
    public ResponseEntity<String> addAnime(@RequestBody AnimeDTO dto) {
        try {
            animeService.addAnime(dto);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body("Failed to save Anime");
        }
        return ResponseEntity.ok("Anime Saved");

        
    }

    // Read Method(s)

    @GetMapping("/list-anime")
    public ResponseEntity<List<Anime>> listAnime() {
        List<Anime> list = animeRepository.findAll();
        return ResponseEntity.ok(list);
    }


    // Update Method
    @PatchMapping("/{id}/title")
    public ResponseEntity<Anime> updateAnimeByTitle(
        @PathVariable UUID id,
        @RequestBody UpdateAnimeDTO dto) {
            return animeRepository.findById(id)
                                  .map(item -> {
                                    item.setTitle(dto.getTitle());
                                    Anime update = animeRepository.save(item);
                                    return ResponseEntity.ok(update);
                                  })
                                  .orElseGet(() -> ResponseEntity.notFound().build());
        }


    // // Delete Method
    // @DeleteMapping("/delete/{id}")
    // public ResponseEntity<Anime> deleteAnimebyTitle() {
    //     return null;
    // }
}
