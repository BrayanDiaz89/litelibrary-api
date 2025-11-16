package com.bdiaz89.litelibrary_api.service.entitie;

import com.bdiaz89.litelibrary_api.domain.dto.AuthorRequestDTO;
import com.bdiaz89.litelibrary_api.domain.dto.AuthorResponseDTO;
import com.bdiaz89.litelibrary_api.domain.dto.AuthorUpdateDateOfDeathDTO;
import com.bdiaz89.litelibrary_api.domain.dto.AuthorWithListBooksDTO;
import com.bdiaz89.litelibrary_api.domain.exception.AuthorDoesNotExistsException;
import com.bdiaz89.litelibrary_api.domain.exception.InvalidRangeAgesSearchException;
import com.bdiaz89.litelibrary_api.service.bussinesrules.create.AuthorCreationValidator;
import com.bdiaz89.litelibrary_api.service.bussinesrules.patch.AuthorPatchValidator;
import com.bdiaz89.litelibrary_api.service.bussinesrules.access.AuthorAccessValidator;
import com.bdiaz89.litelibrary_api.service.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository repository;
    private final List<AuthorCreationValidator> creationValidators;
    private final List<AuthorAccessValidator> accessValidators;
    private final List<AuthorPatchValidator> patchValidators;

    public AuthorService(AuthorRepository repository, List<AuthorCreationValidator> validatorsCreate, List<AuthorCreationValidator> creationValidators, List<AuthorAccessValidator> updateValidators, List<AuthorAccessValidator> accessValidators, List<AuthorPatchValidator> patchValidators) {
        this.repository = repository;
        this.creationValidators = creationValidators;
        this.accessValidators = accessValidators;
        this.patchValidators = patchValidators;
    }

    public AuthorResponseDTO createAuthor(AuthorRequestDTO request){
        creationValidators.forEach(v -> v.validate(request));
        return repository.createAuthor(request);
    }

    public List<AuthorResponseDTO> getListOfAuthors() {
        return repository.findAll();
    }

    public List<AuthorWithListBooksDTO> getListAuthorsWithBooks() {
        return repository.findAllWithBooks();
    }

    public AuthorResponseDTO getAuthorById(Long id) {
        accessValidators.forEach(v-> v.validate(id));
        return repository.findByIdResponse(id);
    }

    public AuthorWithListBooksDTO getAuthorWithBooksById(Long id) {
        accessValidators.forEach(v-> v.validate(id));
        return repository.findByIdResponseWithBooks(id);
    }


    public List<AuthorWithListBooksDTO> getAllAuthorsByNameOrLastnameOrBirthDateOrDeathDate(
            String name, String lastname, Integer birthYear, Integer deathYear) {
        return repository.findAllByNameOrLastnameOrBirthYearOrDeathYear(name, lastname, birthYear, deathYear);
    }

    public List<AuthorWithListBooksDTO> getAllAuthorsBetweenBirthYear(Integer startBirthyear, Integer endBirthyear) {
        if (startBirthyear > endBirthyear){
            throw new InvalidRangeAgesSearchException("El rango de edad a filtrar no es coherente, por favor revisar.");
        }
        return repository.findAuthorsByBirthDate(startBirthyear, endBirthyear);
    }

    public AuthorResponseDTO updateAuthor(Long id, AuthorRequestDTO request) {
        accessValidators.forEach(v-> v.validate(id));
        creationValidators.forEach(v-> v.validate(request));
        return repository.updateAuthor(id, request);
    }

    public AuthorResponseDTO updateFieldDateOfDeath(Long id, AuthorUpdateDateOfDeathDTO request) {
        accessValidators.forEach(v-> v.validate(id));
        return repository.updateAuthorFieldDateOfDeath(id, request);
    }

    public void deleteAuthor(Long id) {
        accessValidators.forEach(v-> v.validate(id));
        repository.delete(id);
    }
}