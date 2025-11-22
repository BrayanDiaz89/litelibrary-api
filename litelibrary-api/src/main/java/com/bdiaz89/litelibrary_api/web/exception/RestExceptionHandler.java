package com.bdiaz89.litelibrary_api.web.exception;

import com.bdiaz89.litelibrary_api.domain.entitie.Genre;
import com.bdiaz89.litelibrary_api.domain.exception.*;
import com.bdiaz89.litelibrary_api.domain.exception.book.*;
import com.bdiaz89.litelibrary_api.domain.exception.customer.CustomerAlreadyExistsException;
import com.bdiaz89.litelibrary_api.domain.exception.customer.CustomerDoesNotExistsException;
import com.bdiaz89.litelibrary_api.domain.exception.loan.InvalidBookListException;
import com.bdiaz89.litelibrary_api.domain.exception.loan.LoanDoesNotExistsException;
import com.bdiaz89.litelibrary_api.domain.exception.loan.RequestedBooksNotAvailableException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @ExceptionHandler(BookDoesNotExistsException.class)
    public ResponseEntity<Void> handleExceptionBookDoesNotExists(BookDoesNotExistsException ex){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(InvalidParametersSearchException.class)
    public ResponseEntity<ErrorResponseDTO> handleExceptionInvalidParametersSearch(InvalidParametersSearchException ex){
        ErrorResponseDTO error = new ErrorResponseDTO("invalid-parameter-search", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponseDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {

        Throwable cause = ex.getCause();

        if (cause instanceof InvalidFormatException ifx
                && ifx.getTargetType().isEnum()
                && ifx.getTargetType().equals(Genre.class)) {

            String invalidValue = String.valueOf(ifx.getValue());

            String allowedValues = Arrays.stream(Genre.values())
                    .map(Enum::name)
                    .collect(Collectors.joining(", "));

            String message = String.format(
                    "El valor '%s' no es un género válido. Valores permitidos: [%s]",
                    invalidValue,
                    allowedValues
            );

            ErrorResponseDTO error = new ErrorResponseDTO("invalid-genre", message);
            return ResponseEntity.badRequest().body(error);
        }

        ErrorResponseDTO generic = new ErrorResponseDTO(
                "invalid-request-body",
                "El cuerpo de la petición no es válido o está mal formado."
        );
        return ResponseEntity.badRequest().body(generic);
    }

    @ExceptionHandler(PublicationYearIsNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleExceptionPublicationYearIsNotValid(PublicationYearIsNotValidException ex){
        ErrorResponseDTO error = new ErrorResponseDTO("publication-year-not-valid", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(CustomerDoesNotExistsException.class)
    public ResponseEntity<Void> handleExceptionBookDoesNotExists(CustomerDoesNotExistsException ex){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleExceptionCustomerAlreadyExists(CustomerAlreadyExistsException ex){
        ErrorResponseDTO error = new ErrorResponseDTO("customer-already-exists", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(InvalidBookListException.class)
    public ResponseEntity<ErrorResponseDTO> handleExceptionInvalidBookList(InvalidBookListException ex){
        ErrorResponseDTO error = new ErrorResponseDTO("invalid-book-list", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(RequestedBooksNotAvailableException.class)
    public ResponseEntity<ErrorResponseDTO> handleExceptionRequestedBooksNotAvailable(RequestedBooksNotAvailableException ex){
        ErrorResponseDTO error = new ErrorResponseDTO("requested-books-not-available", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(LoanDoesNotExistsException.class)
    public ResponseEntity<Void> handleExceptionLoanDoesNotExists(LoanDoesNotExistsException ex){
        return ResponseEntity.notFound().build();
    }

}
