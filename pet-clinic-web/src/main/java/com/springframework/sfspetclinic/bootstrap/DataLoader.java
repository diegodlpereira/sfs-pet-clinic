package com.springframework.sfspetclinic.bootstrap;

import com.springframework.sfspetclinic.model.Owner;
import com.springframework.sfspetclinic.model.Pet;
import com.springframework.sfspetclinic.services.OwnerService;
import com.springframework.sfspetclinic.services.PetService;
import com.springframework.sfspetclinic.services.map.OwnerServiceMap;
import com.springframework.sfspetclinic.services.map.PetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final PetService petService;

    public DataLoader(){
        ownerService = new OwnerServiceMap();
        petService = new PetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Joao");
        owner1.setLastName("Caldas");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Rafael");
        owner2.setLastName("Cysneiros");

        ownerService.save(owner2);

        System.out.println("Owners added..");

        Pet pet1 = new Pet();
        pet1.setId(1L);
        pet1.setOwner(owner1);

        petService.save(pet1);

        Pet pet2 = new Pet();
        pet2.setId(1L);
        pet2.setOwner(owner2);
        petService.save(pet2);

        System.out.println("Pets added..");

    }
}


