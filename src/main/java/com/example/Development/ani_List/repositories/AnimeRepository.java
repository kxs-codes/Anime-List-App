package com.example.Development.ani_List.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Development.ani_List.domains.Anime;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, UUID > {
}
