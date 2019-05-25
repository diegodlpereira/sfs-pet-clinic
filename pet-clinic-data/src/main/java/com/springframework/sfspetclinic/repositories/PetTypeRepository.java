package com.springframework.sfspetclinic.repositories;

import com.springframework.sfspetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
