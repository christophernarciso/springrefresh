package com.cnar.kurime.repositories;

import com.cnar.kurime.entities.Media;
import com.cnar.kurime.entities.MediaType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {

    Optional<Media> findByAuthor(String author);

    Optional<Media> findByArtist(String artist);

    List<Media> getAllByTitle(String title);

}