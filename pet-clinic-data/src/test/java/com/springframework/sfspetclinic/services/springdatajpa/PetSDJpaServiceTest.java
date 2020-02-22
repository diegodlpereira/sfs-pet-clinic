package com.springframework.sfspetclinic.services.springdatajpa;

import com.springframework.sfspetclinic.model.Pet;
import com.springframework.sfspetclinic.repositories.PetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 *
 */
public class PetSDJpaServiceTest {

    PetSDJpaService petSDJpaService;

    @Mock
    PetRepository petRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        petSDJpaService = new PetSDJpaService(petRepository);
    }

    @Test
    public void findAll() {
        Pet pet = new Pet();
        HashSet<Pet> petsData = new HashSet<>();
        petsData.add(pet);

        when(petRepository.findAll()).thenReturn(petsData);

        Set<Pet> pets = petSDJpaService.findAll();

        assertEquals(1, pets.size());

        verify(petRepository, times(1)).findAll();
    }
}