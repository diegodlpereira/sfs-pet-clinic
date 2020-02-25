package com.springframework.sfspetclinic.services.springdatajpa;

import com.springframework.sfspetclinic.model.Owner;
import com.springframework.sfspetclinic.repositories.OwnerRepository;
import com.springframework.sfspetclinic.repositories.PetRepository;
import com.springframework.sfspetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";
    public static final Long ID = 1l;

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    OwnerSDJpaService service;
    Owner returnOwner;

    @BeforeEach
    void setUp() {
        service = new OwnerSDJpaService(ownerRepository, petRepository, petTypeRepository);

        returnOwner = Owner.builder().id(ID).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner owner = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, owner.getLastName());
    }

    @Test
    void findAll() {
        //given
        Set<Owner> ownersMock = new HashSet<>();
        ownersMock.add(returnOwner);
        ownersMock.add(Owner.builder().id(2l).build());

        when(ownerRepository.findAll()).thenReturn(ownersMock);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(ID);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(ID);

        assertNull(owner);
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = service.save(returnOwner);

        assertNotNull(savedOwner);
        assertEquals(returnOwner, savedOwner);

        service.save(Owner.builder().id(2l).build());

        verify(ownerRepository, times(2)).save(any());
    }

    @Test
    void delete() {
        service.delete(returnOwner);

        //1 is the default times()
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(returnOwner.getId());

        verify(ownerRepository).deleteById(anyLong());

    }
}