package com.springframework.sfspetclinic.bootstrap;

import com.springframework.sfspetclinic.model.*;
import com.springframework.sfspetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtiesService specialtiesService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0){
            loadData();
        }

    }

    private void loadData() {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtiesService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtiesService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtiesService.save(dentistry);


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

        owner2.getPets().add(bobsCat);

        ownerService.save(owner2);

        Visit bobsCatVisit = new Visit();
        bobsCatVisit.setDescription("Sneezy cat");
        bobsCatVisit.setPet(bobsCat);
        bobsCatVisit.setDate(LocalDate.now());

        visitService.save(bobsCatVisit);


        System.out.println("Owners added..");

        Vet vet1 = new Vet();
        vet1.setFirstName("Laszlo");
        vet1.setLastName("Szabo");
        vet1.getSpecialties().add(savedRadiology);


        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Clovis");
        vet2.setLastName("Casoy");
        vet2.getSpecialties().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Vets added..");
    }
}


