package ru.gb.patterns.service.implementation;

import org.springframework.stereotype.Service;
import ru.gb.patterns.dto.BalloonDto;
import ru.gb.patterns.model.Balloon;
import ru.gb.patterns.repository.BalloonRepository;
import ru.gb.patterns.service.BalloonService;

import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImpl implements BalloonService {

    private final BalloonRepository balloonRepository;

    public BalloonServiceImpl(BalloonRepository balloonRepository) {
        this.balloonRepository = balloonRepository;
    }

    @Override
    public Optional<Balloon> findByType(String type) {
        return balloonRepository.findByType(type);
    }

    @Override
    public List<Balloon> findAll() {
        return balloonRepository.findAllByDeletedIsFalse();
    }

    @Override
    public void save(Balloon balloon) {
        balloonRepository.save(balloon);
    }

    @Override
    public Balloon createNewType(BalloonDto dto) {
        Balloon balloon = new Balloon.Builder(dto.getType())
                .volume(dto.getVolume())
                .weight(dto.getWeight())
                .build();
        save(balloon);
        return balloon;
    }

}
