package com.example.petclinic.service.map;

import com.example.petclinic.model.Visit;
import com.example.petclinic.service.VisitService;

public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Visit save(Visit object) {
        if (object.getPet() == null
                || object.getPet().getOwner() == null
                || object.getPet().getId() == null
                || object.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid visit");
        }
        return super.save(object);
    }
}
