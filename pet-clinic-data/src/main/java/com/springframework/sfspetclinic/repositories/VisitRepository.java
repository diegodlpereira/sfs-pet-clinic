package com.springframework.sfspetclinic.repositories;

import com.springframework.sfspetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
