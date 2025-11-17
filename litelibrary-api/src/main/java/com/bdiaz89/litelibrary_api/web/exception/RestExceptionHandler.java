package com.bdiaz89.litelibrary_api.web.exception;

import com.bdiaz89.litelibrary_api.domain.exception.*;
import com.bdiaz89.litelibrary_api.domain.exception.book.ISBNAlreadyExistsException;
import com.bdiaz89.litelibrary_api.domain.exception.book.InvalidAuthorListException;
import com.bdiaz89.litelibrary_api.domain.exception.book.TitleAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(AuthorAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleExceptionAuthorExists(AuthorAlreadyExistsException ex){
        ErrorResponseDTO error = new ErrorResponseDTO("author-already-exists", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(AuthorDoesNotExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleExceptionAuthorNotFound(AuthorDoesNotExistsException ex){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(AuthorWithInvalidAgeException.class)
    public ResponseEntity<ErrorResponseDTO> handleExceptionAuthorWithInvalidAge(AuthorWithInvalidAgeException ex){
        ErrorResponseDTO error = new ErrorResponseDTO("author-with-invalid-age", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(InvalidRangeAgesSearchException.class)
    public ResponseEntity<ErrorResponseDTO> handleExceptionInvalidRangeAgesSearch(InvalidRangeAgesSearchException ex){
        ErrorResponseDTO error = new ErrorResponseDTO("invalid-range-ages-search", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(InvalidRecordedDateException.class)
    public ResponseEntity<ErrorResponseDTO> handleExceptionInvalidRecordedDate(InvalidRecordedDateException ex){
        ErrorResponseDTO error = new ErrorResponseDTO("invalid-recorded-date", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorResponseDTO>> handleException400(MethodArgumentNotValidException ex){
        List<ErrorResponseDTO> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(e -> {
            errors.add(new ErrorResponseDTO(e.getField(), e.getDefaultMessage()));
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(InvalidAuthorListException.class)
    public ResponseEntity<ErrorResponseDTO> handleExceptionInvalidAuthorList(InvalidAuthorListException ex){
        ErrorResponseDTO error = new ErrorResponseDTO("invalid-list-author", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(ISBNAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleExceptionISBNAlreadyExists(ISBNAlreadyExistsException ex){
        ErrorResponseDTO error = new ErrorResponseDTO("isbn-already-exists", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(TitleAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleExceptionTitleAlreadyExists(TitleAlreadyExistsException ex){
        ErrorResponseDTO error = new ErrorResponseDTO("title-already-exists", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
