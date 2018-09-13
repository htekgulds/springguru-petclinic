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
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(
            OwnerService ownerService,
            VetService vetService,
            PetService petService,
            PetTypeService petTypeService,
            SpecialtyService specialtyService,
            VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
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
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCat = petTypeService.save(cat);

        System.out.println("Loaded pet types");

//        Owners
        Owner owner1 = new Owner();
        owner1.setFirstName("Hasan");
        owner1.setLastName("Tekgül");
        owner1.setAddress("Şefkat mah. Keçiören");
        owner1.setCity("Ankara");
        owner1.setTelephone("123123123");

        Pet pet1 = new Pet();
        pet1.setName("Karabaş");
        pet1.setType(savedDog);
        pet1.setOwner(owner1);
        pet1.setBirthDate(LocalDate.now());
        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mahmut");
        owner2.setLastName("Tuncer");
        owner1.setAddress("Şefkat mah. Keçiören");
        owner1.setCity("Ankara");
        owner1.setTelephone("345345345");

        Pet pet2 = new Pet();
        pet2.setName("Pamuk");
        pet2.setType(savedCat);
        pet2.setOwner(owner2);
        pet2.setBirthDate(LocalDate.now());
        owner2.getPets().add(pet2);

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

//        Specialties
        Specialty radio = new Specialty();
        radio.setDescription("radiology");
        Specialty savedRadio = specialtyService.save(radio);

        Specialty surgery = new Specialty();
        surgery.setDescription("surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentist = new Specialty();
        dentist.setDescription("dentistry");
        Specialty savedDentist = specialtyService.save(dentist);

//        Vets
        Vet vet1 = new Vet();
        vet1.setFirstName("Darth");
        vet1.setLastName("Vader");
        vet1.getSpecialties().add(savedRadio);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Luke");
        vet2.setLastName("Skywalker");
        vet2.getSpecialties().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded vets...");

//        Visits
        Visit visit1 = new Visit();
        visit1.setDate(LocalDate.now());
        visit1.setDescription("Some visit");
        visit1.setPet(pet1);
        visitService.save(visit1);

        Visit visit2 = new Visit();
        visit2.setDate(LocalDate.now());
        visit2.setDescription("Some visit 2");
        visit2.setPet(pet2);
        visitService.save(visit2);
    }
}
