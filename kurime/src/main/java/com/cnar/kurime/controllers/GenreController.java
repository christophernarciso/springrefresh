package com.cnar.kurime.controllers;

import com.cnar.kurime.entities.Genre;
import com.cnar.kurime.services.GenreService;
import com.cnar.kurime.util.exceptions.GenreNotFoundException;
import com.cnar.kurime.util.logic.ResponseEntityLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    GenreService genreService;

    @GetMapping("/")
    public ResponseEntity<List<Genre>> getAllGenres() {
        return new ResponseEntity<>(genreService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenre(@PathVariable Long id) throws GenreNotFoundException {
        return new ResponseEntityLogic().sendResponse(genreService.getGenre(id));
    }

    @PostMapping("/")
    public ResponseEntity<Genre> create(@RequestBody Genre genre) {
        return new ResponseEntity<>(genreService.createGenre(genre), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        genreService.deleteGenre(id);
    }

}
