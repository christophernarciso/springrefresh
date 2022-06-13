package com.cnar.kurime.controllers;

import com.cnar.kurime.entities.Genre;
import com.cnar.kurime.entities.Media;
import com.cnar.kurime.services.MediaService;
import com.cnar.kurime.util.exceptions.MediaNotFoundException;
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

    @PostMapping("/")
    public ResponseEntity<Media> create(@RequestBody Media media) {
        return new ResponseEntity<>(mediaService.createNewMedia(media), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        mediaService.deleteMedia(id);
    }

}
