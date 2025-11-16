package com.bdiaz89.litelibrary_api.domain.entitie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Book {

    private Long id;
    private String title;
    private Author author;
    private String ISBN;
    private Integer yearOfPublication;
    private Genre genre;
    private StatusBook status;

}
