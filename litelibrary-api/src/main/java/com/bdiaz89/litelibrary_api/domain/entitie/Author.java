package com.bdiaz89.litelibrary_api.domain.entitie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Author {

    private Long idAuthor;
    private String nameAuthor;
    private String lastnameAuthor;
    private LocalDate birthdate;
    private LocalDate dateOfDeath;

}
