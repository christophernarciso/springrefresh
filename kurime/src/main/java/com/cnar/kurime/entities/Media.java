package com.cnar.kurime.entities;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "media", indexes = {
        @Index(name = "idx_media_med_title", columnList = "med_title")
})
public class Media implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "med_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "med_title", length = 50)
    private String title;

    @Column(name = "med_author", length = 50)
    private String author;

    @Column(name = "med_artist", length = 50)
    private String artist;

    @Column(name = "med_type_id")
    private Long mediaTypeId;

    /*
               The joinColumn attribute will connect to the owner side of the relationship,
               and the inverseJoinColumn to the other side
             */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "media_genres",
            joinColumns = @JoinColumn(name = "med_id"),
            inverseJoinColumns = @JoinColumn(name = "gen_id"))
    List<Genre> mediaGenres = new ArrayList<>();

    @Column(name = "med_description")
    private String description;

    @Column(name = "med_path")
    private String mediaPath;

    public Long getMediaTypeId() {
        return mediaTypeId;
    }

    public void setMediaTypeId(Long mediaTypeId) {
        this.mediaTypeId = mediaTypeId;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getMediaPath() {
        return mediaPath;
    }

    public void setMediaPath(String mediaPath) {
        this.mediaPath = mediaPath;
    }

    public List<Genre> getMediaGenres() {
        return mediaGenres;
    }

    public void setMediaGenres(List<Genre> mediaGenres) {
        this.mediaGenres = mediaGenres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Media media = (Media) o;
        return id != null && Objects.equals(id, media.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "title = " + title + ", " +
                "author = " + author + ", " +
                "artist = " + artist + ", " +
                "med_type_id = " + mediaTypeId + ", " +
                "description = " + description + ", " +
                "mediaPath = " + mediaPath + ")";
    }
}
