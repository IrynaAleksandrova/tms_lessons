package org.example.service;

import org.example.domain.Pair;

import java.util.List;

public interface CheckService {
    void checkWinner(int race, List<Pair> racer);
    void checkResult(int money, boolean isWinner);
}
