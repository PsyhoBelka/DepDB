package ua.rozhkov.springdepdb.service;

import java.util.List;

public interface BaseService<T, ID> {
    T findById(ID id);

    List<T> findAll();

    T findByName(String name);

    ID add(T object);

    ID update(T newObject);

    void deleteById(ID id);
}
