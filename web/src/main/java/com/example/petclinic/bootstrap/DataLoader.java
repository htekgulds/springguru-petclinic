package com.example.petclinic.bootstrap;

import com.example.petclinic.model.*;
import com.example.petclinic.service.OwnerService;
import com.example.petclinic.service.PetTypeService;
import com.example.petclinic.service.SpecialtyService;
import com.example.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
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
    }
}
