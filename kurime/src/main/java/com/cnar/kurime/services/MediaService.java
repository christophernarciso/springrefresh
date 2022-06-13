package com.cnar.kurime.services;

import com.cnar.kurime.entities.Genre;
import com.cnar.kurime.entities.Media;
import com.cnar.kurime.repositories.MediaRepository;
import com.cnar.kurime.util.exceptions.MediaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MediaService {

    @Autowired
    MediaRepository mediaRepository;

    /**
     * @return all available media in the repository
     */
    public List<Media> getAll() {
        return mediaRepository.findAll();
    }

    /**
     * @param id
     * @return the media found in the repository for Long id
     * @throws MediaNotFoundException
     */
    public Optional<Media> getMedia(Long id) throws MediaNotFoundException {
        return Optional.of(mediaRepository.findById(id))
                .orElseThrow(() -> new MediaNotFoundException("Media not found for id: " + id));
    }

    /**
     * @param mediaId
     * @return the list of genres associated with the media
     * @throws MediaNotFoundException
     */
    public List<Genre> getMediaGenres(Long mediaId) throws MediaNotFoundException {
        Optional<Media> media = getMedia(mediaId);

        if (media.isPresent())
            return media.get().getMediaGenres();

        return Collections.emptyList();
    }

    /**
     * @param media request body to be saved
     * @return the new saved entity in the repository
     */
    public Media createNewMedia(Media media) {
        return mediaRepository.save(media);
    }

    /**
     * @param id the media id to delete
     */
    public void deleteMedia(Long id) {
        mediaRepository.deleteById(id);
    }
}
