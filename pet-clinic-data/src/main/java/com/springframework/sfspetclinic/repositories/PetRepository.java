package com.springframework.sfspetclinic.repositories;

import com.springframework.sfspetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
