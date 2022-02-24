package ru.gb.patterns.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.patterns.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
