package ru.gb.patterns.service;

import ru.gb.patterns.dto.BalloonDto;
import ru.gb.patterns.model.Balloon;

import java.util.List;
import java.util.Optional;

public interface BalloonService {

    Optional<Balloon> findByType(String type);

    List<Balloon> findAll();

    void save(Balloon balloon);

    Balloon createNewType(BalloonDto balloonDto);

}
