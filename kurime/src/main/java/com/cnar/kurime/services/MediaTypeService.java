package com.cnar.kurime.services;

import com.cnar.kurime.entities.MediaType;
import com.cnar.kurime.repositories.MediaTypeRepository;
import com.cnar.kurime.util.exceptions.MediaTypeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediaTypeService {

    @Autowired
    MediaTypeRepository mediaTypeRepository;

    /**
     * @return all available media types in the repository
     */
    public List<MediaType> getAll() {
        return mediaTypeRepository.findAll();
    }

    /**
     * @param typeId
     * @return get the media type entity for typeId
     * @throws MediaTypeNotFoundException
     */
    public Optional<MediaType> getMediaType(Long typeId) throws MediaTypeNotFoundException {
        return Optional.of(mediaTypeRepository.findById(typeId))
                .orElseThrow(() -> new MediaTypeNotFoundException("Media type not found for id: " + typeId));
    }

    /**
     * @param mediaType
     * @return the saved entity from the repository mediaType
     */
    public MediaType createMediaType(MediaType mediaType) {
        return mediaTypeRepository.save(mediaType);
    }

    /**
     * @param id delete the entity by id
     */
    public void deleteMediaType(Long id) {
        mediaTypeRepository.deleteById(id);
    }

}
