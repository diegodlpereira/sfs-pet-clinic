package com.springframework.sfspetclinic.services.springdatajpa;

import com.springframework.sfspetclinic.repositories.OwnerRepository;
import com.springframework.sfspetclinic.repositories.PetRepository;
import com.springframework.sfspetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    OwnerSDJpaService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        service = new OwnerSDJpaService(ownerRepository, petRepository, petTypeRepository);
    }

    @Test
    void findByLastName() {
    }

    @Test
    void findAll() {

    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}