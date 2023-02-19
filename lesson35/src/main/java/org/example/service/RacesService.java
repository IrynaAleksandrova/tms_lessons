package org.example.service;

import org.example.domain.Pair;

import java.util.List;

public interface RacesService {

    List<Pair> race(List<Pair> racer);

    void start(List<Pair> racers, Integer pairNumber, Integer money);

}
