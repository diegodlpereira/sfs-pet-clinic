package com.springframework.sfspetclinic.repositories;

import com.springframework.sfspetclinic.model.Owner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Integration tests Class for the Owner Repository
 * Obs: That brings up the Spring Context
 */
/*
@DataJpaTest
@RunWith(SpringRunner.class)
*/
public class OwnerRepositoryTestIT {

    @Autowired
    OwnerRepository ownerRepository;

    @BeforeAll
    public void setUp() throws Exception {
    }

    @Test
    @Disabled
    public void findByLastName() {

     Owner owner = ownerRepository.findByLastName("Caldas");

     assertEquals("Caldas", owner.getLastName());
    }
}
