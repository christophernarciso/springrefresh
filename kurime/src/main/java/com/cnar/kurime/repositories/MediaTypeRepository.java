package com.cnar.kurime.repositories;

import com.cnar.kurime.entities.MediaType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MediaTypeRepository extends JpaRepository<MediaType, Long> {
    Optional<MediaType> findByTypeName(String typeName);

    List<MediaType> getAllByTypeName(String typeName);
}