package com.example.petclinic.bootstrap;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.PetType;
import com.example.petclinic.model.Vet;
import com.example.petclinic.service.OwnerService;
import com.example.petclinic.service.PetTypeService;
import com.example.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
//        Pet Types
        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);

        System.out.println("Loaded pet types");

//        Owners
        Owner owner1 = new Owner();
        owner1.setFirstName("Hasan");
        owner1.setLastName("Tekgül");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mahmut");
        owner2.setLastName("Tuncer");
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

//        Vets
        Vet vet1 = new Vet();
        vet1.setFirstName("Darth");
        vet1.setLastName("Vader");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Luke");
        vet2.setLastName("Skywalker");
        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
