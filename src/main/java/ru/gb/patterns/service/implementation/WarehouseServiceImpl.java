package ru.gb.patterns.service.implementation;

import org.springframework.stereotype.Service;
import ru.gb.patterns.model.Warehouse;
import ru.gb.patterns.repository.WarehouseRepository;
import ru.gb.patterns.service.WarehouseService;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository warehouseRepository;

    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public Optional<Warehouse> findById(Long id) {
        return warehouseRepository.findById(id);
    }

    @Override
    public List<Warehouse> findAll() {
        return warehouseRepository.findAllByDeletedIsFalse();
    }

    @Override
    public void save(Warehouse warehouse) {
        warehouseRepository.save(warehouse);
    }

    @Override
    public void delete(Warehouse warehouse) {
        warehouse.setDeleted(true);
        warehouseRepository.save(warehouse);
    }

}
