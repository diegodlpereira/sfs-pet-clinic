package com.springframework.sfspetclinic.bootstrap;

import com.springframework.sfspetclinic.model.Owner;
import com.springframework.sfspetclinic.model.Vet;
import com.springframework.sfspetclinic.services.OwnerService;
import com.springframework.sfspetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }
    
    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Joao");
        owner1.setLastName("Caldas");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Rafael");
        owner2.setLastName("Cysneiros");

        ownerService.save(owner2);

        System.out.println("Owners added..");

        Vet vet1 = new Vet();
        vet1.setFirstName("Laszlo");
        vet1.setLastName("Szabo");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Clovis");
        vet2.setLastName("Casoy");

        vetService.save(vet2);

        System.out.println("Vets added..");

    }
}


