package com.example.petclinic.bootstrap;

import com.example.petclinic.model.*;
import com.example.petclinic.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(
            OwnerService ownerService,
            VetService vetService,
            PetTypeService petTypeService,
            SpecialtyService specialtyService,
            VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
//        Pet Types
        PetType dog = petTypeService.save(new PetType("dog"));
        PetType cat = petTypeService.save(new PetType("cat"));
        System.out.println("Loaded pet types");

//        Owners with Pets
        Pet narutosDog = Pet.builder().name("karabaş").type(dog).birthDate(LocalDate.now()).build();
        Owner naruto = Owner.builder()
                .firstName("uzumaki")
                .lastName("naruto")
                .address("leaf village")
                .city("land of fire")
                .telephone("123123123")
                .pet(narutosDog)
                .build();
        narutosDog.setOwner(naruto);
        ownerService.save(naruto);

        Pet mahmutsCat = Pet.builder().name("pamuk").type(cat).birthDate(LocalDate.now()).build();
        Owner mahmut = Owner.builder()
                .firstName("mahmut")
                .lastName("tuncer")
                .address("la la land")
                .city("turkey")
                .telephone("345345345")
                .pet(mahmutsCat)
                .build();
        mahmutsCat.setOwner(mahmut);
        ownerService.save(mahmut);
        System.out.println("Loaded owners...");

//        Specialties
        Specialty radiology = specialtyService.save(new Specialty("radiology"));
        Specialty surgery = specialtyService.save(new Specialty("surgery"));
        System.out.println("Loaded specialties...");

//        Vets
        vetService.save(Vet.builder().firstName("darth").lastName("vader").specialty(radiology).build());
        vetService.save(Vet.builder().firstName("luke").lastName("skywalker").specialty(surgery).build());
        System.out.println("Loaded vets...");

//        Visits
        visitService.save(Visit.builder().date(LocalDate.now()).description("Naruto's visit").pet(narutosDog).build());
        visitService.save(Visit.builder().date(LocalDate.now()).description("Mahmut's visit").pet(mahmutsCat).build());
    }
}
