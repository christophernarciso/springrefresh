package com.cnar.kurime.repositories;

import com.cnar.kurime.entities.Genre;
import com.cnar.kurime.entities.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    Optional<Genre> findByGenreName(String genreName);

    List<Genre> getByGenreName(String genreName);

}