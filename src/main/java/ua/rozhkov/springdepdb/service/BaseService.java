package ua.rozhkov.springdepdb.service;

import java.util.List;

public interface BaseService<T, ID> {
    T findById(ID id);

    List<T> findAll();

    T findByName(String name);

    T save(T object);

    void deleteById(ID id);
}
