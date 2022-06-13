package com.cnar.kurime.util.logic;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class ResponseEntityLogic {

    public ResponseEntityLogic() {}

    /**
     * @param entity
     * @param <T>
     * @return the response type based on entity OK / NOT_FOUND
     */
    public <T> ResponseEntity<T> sendResponse(Optional<T> entity) {
        return entity.map(e -> new ResponseEntity<>(e, HttpStatus.OK))
                .orElse(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

}
