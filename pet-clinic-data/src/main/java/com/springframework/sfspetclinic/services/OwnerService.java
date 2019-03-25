package com.springframework.sfspetclinic.services;

import com.springframework.sfspetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>  {

    Owner findByLastName(String lastName);
}
