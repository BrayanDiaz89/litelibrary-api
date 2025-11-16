package com.bdiaz89.litelibrary_api.domain.entitie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Customer {

    private Long idCustomer;
    private String name;
    private String lastname;
    private Long identityDocument;

}
