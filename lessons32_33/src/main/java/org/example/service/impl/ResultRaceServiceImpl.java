package org.example.service.impl;

import org.example.domain.Pair;
import org.example.domain.PairComparator;
import org.example.service.ResultRaceService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResultRaceServiceImpl implements ResultRaceService {
    @Override
    public List<Pair> getResult(List<Pair> racer) {
        racer.sort(new PairComparator());
        return racer;
    }

    @Override
    public boolean isWinner(List<Pair> racer, Pair chosen) {
        return chosen.equals(racer.get(0));
    }

}
