package com.springframework.sfspetclinic.repositories;

import com.springframework.sfspetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
