package ru.gb.patterns.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.patterns.dto.BalloonDto;
import ru.gb.patterns.model.Balloon;
import ru.gb.patterns.service.BalloonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/balloons")
public class BalloonRestController {

    private final BalloonService balloonService;

    public BalloonRestController(BalloonService balloonService) {
        this.balloonService = balloonService;
    }

    @GetMapping
    public ResponseEntity<List<Balloon>> getAllBalloons() {
        return ResponseEntity.ok(balloonService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> createNewBalloon(@RequestBody BalloonDto requestDto) {
        Optional<Balloon> optional = balloonService.findByType(requestDto.getType());
        if (optional.isPresent()) {
            return new ResponseEntity<>("Balloon type already exists: " + requestDto.getType(), HttpStatus.FORBIDDEN);
        }
        Balloon balloon = balloonService.createNewType(requestDto);
        return ResponseEntity.ok(balloon);
    }

}
