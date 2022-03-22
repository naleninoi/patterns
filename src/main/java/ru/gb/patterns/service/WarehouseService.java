package ru.gb.patterns.service;

import ru.gb.patterns.model.Warehouse;

import java.util.List;
import java.util.Optional;

public interface WarehouseService {

    Optional<Warehouse> findById(Long id);

    List<Warehouse> findAll();

    void save(Warehouse warehouse);

    void delete(Warehouse warehouse);

}
