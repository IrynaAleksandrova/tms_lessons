package org.example.service;

import org.example.domain.Pair;
import org.springframework.ui.Model;

import java.util.List;

public interface RacesService {

    List<Pair> race(List<Pair> racer);

    void start(List<Pair> racers, Integer pairNumber, Integer money);

}
