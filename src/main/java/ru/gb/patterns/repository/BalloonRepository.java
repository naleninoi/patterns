package ru.gb.patterns.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.patterns.model.Balloon;

import java.util.List;
import java.util.Optional;

@Repository
public interface BalloonRepository extends CrudRepository<Balloon, Long> {
    Optional<Balloon> findByType(String type);
    List<Balloon> findAllByDeletedIsFalse();
}
