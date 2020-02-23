package com.springframework.sfspetclinic.services.map;

import com.springframework.sfspetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerServiceMapTest {

    final Long OWNER_ID = 1L;
    final String LAST_NAME = "Smith";
    OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(OWNER_ID).lastName("Smith").build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();

        assertEquals(1, owners.size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(OWNER_ID);

        assertEquals(OWNER_ID, owner.getId());
    }

    @Test
    void saveWithIDSet() {
        final Long SAVE_OWNER_ID = 2L;
        Owner owner2 = Owner.builder().id(SAVE_OWNER_ID).build();

        Owner ownerSaved = ownerServiceMap.save(owner2);

        assertEquals(SAVE_OWNER_ID, ownerSaved.getId());
    }

    @Test
    void saveWithNoIDSet(){
        Owner owner = Owner.builder().build();

        Owner ownerSave = ownerServiceMap.save(owner);

        assertNotNull(ownerSave.getId());
    }

    @Test
    void delete() {

        ownerServiceMap.delete(ownerServiceMap.findById(OWNER_ID));

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(OWNER_ID);

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {

        assertEquals(LAST_NAME, ownerServiceMap.findByLastName(LAST_NAME).getLastName());
    }
}