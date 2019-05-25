package com.springframework.sfspetclinic.repositories;

import com.springframework.sfspetclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
