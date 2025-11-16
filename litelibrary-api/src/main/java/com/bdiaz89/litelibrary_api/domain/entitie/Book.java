package com.bdiaz89.litelibrary_api.domain.entitie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {

    private Long id;
    private String title;
    private List<Author> authors;
    private String ISBN;
    private Integer yearOfPublication;
    private Genre genre;
    private StatusBook status;

}
