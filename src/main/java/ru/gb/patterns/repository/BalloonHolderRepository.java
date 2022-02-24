package ru.gb.patterns.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.patterns.model.BalloonHolder;

@Repository
public interface BalloonHolderRepository extends CrudRepository<BalloonHolder, Long> {

}
