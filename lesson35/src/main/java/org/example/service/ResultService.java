package org.example.service;

import org.example.domain.Pair;

import java.util.List;

public interface ResultService {

    boolean isWinner(List<Pair> racer, Pair chosen);

}
