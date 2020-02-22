package com.springframework.sfspetclinic.repositories;

import com.springframework.sfspetclinic.model.Owner;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

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

    @Before
    public void setUp() throws Exception {
    }

    @Test
    @Ignore
    public void findByLastName() {

     Owner owner = ownerRepository.findByLastName("Caldas");

     assertEquals("Caldas", owner.getLastName());
    }
}
