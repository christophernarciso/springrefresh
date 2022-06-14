package com.cnar.kurime.services;

import com.cnar.kurime.entities.Genre;
import com.cnar.kurime.repositories.GenreRepository;
import com.cnar.kurime.util.exceptions.GenreNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    @Autowired
    GenreRepository genreRepository;

    /**
     * @return all genres in the repository
     */
    public List<Genre> getAll(){
        return genreRepository.findAll();
    }

    /**
     * @param id
     * @return the genre by its associated id
     */
    public Optional<Genre> getGenre(Long id) throws GenreNotFoundException {
        return Optional.of(genreRepository.findById(id))
                .orElseThrow(() -> new GenreNotFoundException("Genre not found for id: " + id));
    }

    /**
     * @param genre
     * @return the saved entity from the repository
     */
    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    /**
     * @param id the id to delete
     */
    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }

}
