package com.springframework.sfspetclinic.bootstrap;

import com.springframework.sfspetclinic.model.Owner;
import com.springframework.sfspetclinic.model.Pet;
import com.springframework.sfspetclinic.model.PetType;
import com.springframework.sfspetclinic.model.Vet;
import com.springframework.sfspetclinic.services.OwnerService;
import com.springframework.sfspetclinic.services.PetTypeService;
import com.springframework.sfspetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Joao");
        owner1.setLastName("Caldas");
        owner1.setAddress("Rua da Amizade, 123");
        owner1.setCity("Recife");
        owner1.setTelephone("32684998");

        Pet joaosPet = new Pet();
        joaosPet.setPetType(savedDogPetType);
        joaosPet.setOwner(owner1);
        joaosPet.setBirthDate(LocalDate.now());
        joaosPet.setName("Procopio");

        owner1.getPets().add(joaosPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Rafael");
        owner2.setLastName("Cysneiros");
        owner2.setAddress("Rua do Habibs do Prado, 123");
        owner2.setCity("Recife");
        owner2.setTelephone("32323232");

        Pet bobsCat = new Pet();
        bobsCat.setPetType(savedCatPetType);
        bobsCat.setOwner(owner2);
        bobsCat.setBirthDate(LocalDate.now());
        bobsCat.setName("Felicia");

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


