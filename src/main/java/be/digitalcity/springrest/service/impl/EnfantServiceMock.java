package be.digitalcity.springrest.service.impl;

import be.digitalcity.springrest.model.entity.Enfant;
import be.digitalcity.springrest.service.EnfantService;

import java.util.List;

//@Service
// Mockito peut permettre de ne pas avoir à implementer de Mock
// par soit même
public class EnfantServiceMock implements EnfantService {
    @Override
    public Enfant create(Enfant toInsert) {
        return null;
    }

    @Override
    public Enfant update(Long id, Enfant toUpdate) {
        return null;
    }

    @Override
    public Enfant getOne(Long id) {
        return new Enfant();
    }

    @Override
    public List<Enfant> getAll() {
        return List.of(new Enfant());
    }

    @Override
    public Enfant delete(Long id) {
        if(id == 5)
            return null;

        return new Enfant();
    }
}