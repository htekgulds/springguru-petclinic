package com.example.petclinic.service.map;

import com.example.petclinic.model.Specialty;
import com.example.petclinic.service.SpecialtyService;
import org.springframework.stereotype.Service;

@Service
public class SpecialtyServiceMap extends AbstractMapService<Specialty, Long> implements SpecialtyService {
}
