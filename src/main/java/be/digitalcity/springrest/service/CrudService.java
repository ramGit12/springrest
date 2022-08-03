package be.digitalcity.springrest.service;

import be.digitalcity.springrest.model.entity.Enfant;

import java.util.Collection;
import java.util.List;

public interface CrudService<T, TID> {

    // CREATE
    T create(T toInsert);

    // UPDATE
    T update(TID id, T toUpdate);

    // READ
    T getOne(TID id);
    List<T> getAll();

    // DELETE
    T delete(TID id);

    List<T> getAllById(Collection<TID> tid);
}