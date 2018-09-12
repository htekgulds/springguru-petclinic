package com.example.petclinic.service.map;

import com.example.petclinic.model.Owner;
import com.example.petclinic.service.CrudService;
import com.example.petclinic.service.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
