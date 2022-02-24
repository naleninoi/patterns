package ru.gb.patterns.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.patterns.model.Warehouse;

@Repository
public interface WarehouseRepository extends CrudRepository<Warehouse, Long> {

}