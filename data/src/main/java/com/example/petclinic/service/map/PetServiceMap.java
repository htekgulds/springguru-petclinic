package com.example.petclinic.service.map;

import com.example.petclinic.model.Pet;
import com.example.petclinic.service.CrudService;
import com.example.petclinic.service.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
}
