package com.cnar.kurime.services;

import com.cnar.kurime.entities.Genre;
import com.cnar.kurime.entities.Media;
import com.cnar.kurime.entities.MediaType;
import com.cnar.kurime.repositories.MediaRepository;
import com.cnar.kurime.util.exceptions.GenreNotFoundException;
import com.cnar.kurime.util.exceptions.MediaNotFoundException;
import com.cnar.kurime.util.exceptions.MediaTypeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MediaService {

    @Autowired
    MediaRepository mediaRepository;

    @Autowired
    GenreService genreService;

    @Autowired
    MediaTypeService mediaTypeService;

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

    /**
     * @param mediaId
     * @param genreId
     * @return add genreId to mediaId.mediaGenres
     * @throws MediaNotFoundException
     * @throws GenreNotFoundException
     */
    public Optional<Media> addGenre(Long mediaId, Long genreId) throws MediaNotFoundException, GenreNotFoundException {
        Optional<Genre> mediaGenre = genreService.getGenre(genreId);

        if (!mediaGenre.isPresent())
            return Optional.empty();

        Optional<Media> media = getMedia(mediaId);

        // Add genre to mediaGenres list
        media.ifPresent(med -> {
            med.getMediaGenres().add(mediaGenre.get());
            mediaRepository.save(med);
        });

        return getMedia(mediaId);
    }

    /**
     * @param mediaId
     * @param genreId
     * @return remove genreId from mediaId.mediaGenres
     * @throws MediaNotFoundException
     * @throws GenreNotFoundException
     */
    public Optional<Media> removeGenre(Long mediaId, Long genreId) throws GenreNotFoundException, MediaNotFoundException {
        Optional<Genre> mediaGenre = genreService.getGenre(genreId);

        if (!mediaGenre.isPresent())
            return Optional.empty();

        Optional<Media> media = getMedia(mediaId);

        // Add genre to mediaGenres list
        media.ifPresent(med -> {
            med.getMediaGenres().remove(mediaGenre.get());
            mediaRepository.save(med);
        });

        return getMedia(mediaId);
    }

    /**
     * @param mediaId
     * @return get the media type of media entity
     * @throws MediaNotFoundException
     * @throws MediaTypeNotFoundException
     */
    public Optional<MediaType> getMediaType(Long mediaId) throws MediaNotFoundException, MediaTypeNotFoundException {
        Optional<Media> media = getMedia(mediaId);

        return media.isPresent() ? mediaTypeService.getMediaType(media.get().getMediaTypeId()) : Optional.empty();
    }

}
