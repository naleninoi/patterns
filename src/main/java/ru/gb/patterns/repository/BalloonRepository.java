package ru.gb.patterns.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.patterns.model.Balloon;

@Repository
public interface BalloonRepository extends CrudRepository<Balloon, Long> {

}
