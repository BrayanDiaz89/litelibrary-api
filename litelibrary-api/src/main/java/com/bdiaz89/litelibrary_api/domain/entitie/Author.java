package com.bdiaz89.litelibrary_api.domain.entitie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Author {

    private Long idAuthor;
    private String nameAuthor;
    private String lastnameAuthor;
    private LocalDate birthdate;
    private LocalDate dateOfDeath;
    private List<Book> books = new ArrayList<>();

}
