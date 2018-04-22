package com.gr00shik.spring5webapp.repositories;

import com.gr00shik.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
