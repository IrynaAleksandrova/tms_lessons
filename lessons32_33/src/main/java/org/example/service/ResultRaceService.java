package org.example.service;

import org.example.domain.Pair;

import java.util.List;

public interface ResultRaceService {

    List<Pair> getResult(List<Pair> racer);

    boolean isWinner(List<Pair> racer, Pair chosen);
}
