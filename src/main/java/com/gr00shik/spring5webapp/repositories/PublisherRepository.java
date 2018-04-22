package com.gr00shik.spring5webapp.repositories;

import com.gr00shik.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
