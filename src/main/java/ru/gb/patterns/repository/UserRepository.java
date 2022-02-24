package ru.gb.patterns.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.patterns.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
