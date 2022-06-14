package com.cnar.kurime.controllers;

import com.cnar.kurime.entities.Genre;
import com.cnar.kurime.entities.Media;
import com.cnar.kurime.entities.MediaType;
import com.cnar.kurime.services.MediaService;
import com.cnar.kurime.util.exceptions.GenreNotFoundException;
import com.cnar.kurime.util.exceptions.MediaNotFoundException;
import com.cnar.kurime.util.exceptions.MediaTypeNotFoundException;
import com.cnar.kurime.util.logic.ResponseEntityLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/media")
public class MediaController {

    @Autowired
    MediaService mediaService;

    @GetMapping("/")
    public ResponseEntity<List<Media>> getAllMedia() {
        return new ResponseEntity<>(mediaService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Media> getMedia(@PathVariable Long id) throws MediaNotFoundException {
        return new ResponseEntityLogic().sendResponse(mediaService.getMedia(id));
    }

    @GetMapping("/{id}/genres")
    public ResponseEntity<List<Genre>> getMediaGenres(@PathVariable Long id) throws MediaNotFoundException {
        return new ResponseEntity<>(mediaService.getMediaGenres(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/mediatype")
    public ResponseEntity<MediaType> getMediaType(@PathVariable Long id) throws MediaNotFoundException, MediaTypeNotFoundException {
        return new ResponseEntityLogic().sendResponse(mediaService.getMediaType(id));
    }

    @PostMapping("/")
    public ResponseEntity<Media> create(@RequestBody Media media) {
        return new ResponseEntity<>(mediaService.createNewMedia(media), HttpStatus.CREATED);
    }

    @PutMapping("/{mediaId}/addGenre/{genreId}")
    public ResponseEntity<Media> add(@PathVariable Long mediaId, @PathVariable Long genreId) throws MediaNotFoundException, GenreNotFoundException {
        return new ResponseEntityLogic().sendResponse(mediaService.addGenre(mediaId, genreId));
    }

    @DeleteMapping("/{mediaId}/removeGenre/{genreId}")
    public ResponseEntity<Media> remove(@PathVariable Long mediaId, @PathVariable Long genreId) throws MediaNotFoundException, GenreNotFoundException {
        return new ResponseEntityLogic().sendResponse(mediaService.removeGenre(mediaId, genreId));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        mediaService.deleteMedia(id);
    }

}
