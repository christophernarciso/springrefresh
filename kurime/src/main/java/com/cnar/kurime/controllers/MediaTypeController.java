package com.cnar.kurime.controllers;

import com.cnar.kurime.entities.MediaType;
import com.cnar.kurime.services.MediaTypeService;
import com.cnar.kurime.util.exceptions.MediaTypeNotFoundException;
import com.cnar.kurime.util.logic.ResponseEntityLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mediatype")
public class MediaTypeController {

    @Autowired
    MediaTypeService mediaTypeService;

    @GetMapping("/")
    public ResponseEntity<List<MediaType>> getAllMediaTypes() {
        return new ResponseEntity<>(mediaTypeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MediaType> getMediaType(@PathVariable Long id) throws MediaTypeNotFoundException {
        return new ResponseEntityLogic().sendResponse(mediaTypeService.getMediaType(id));
    }

    @PostMapping("/")
    public ResponseEntity<MediaType> create(@RequestBody MediaType mediaType) {
        return new ResponseEntity<>(mediaTypeService.createMediaType(mediaType), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteMediaType(@PathVariable Long id) {
        mediaTypeService.deleteMediaType(id);
    }

}
