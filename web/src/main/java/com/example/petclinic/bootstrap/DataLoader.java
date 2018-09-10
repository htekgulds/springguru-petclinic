package com.example.petclinic.bootstrap;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Vet;
import com.example.petclinic.service.OwnerService;
import com.example.petclinic.service.VetService;
import com.example.petclinic.service.map.OwnerServiceMap;
import com.example.petclinic.service.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Hasan");
        owner1.setLastName("Tekgül");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Mahmut");
        owner2.setLastName("Tuncer");

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
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
