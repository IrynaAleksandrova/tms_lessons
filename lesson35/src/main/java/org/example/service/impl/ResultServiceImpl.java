package org.example.service.impl;

import org.springframework.stereotype.Service;

import org.example.domain.Pair;
import org.example.service.ResultService;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    @Override
    public boolean isWinner(List<Pair> racer, Pair chosen) {
        return chosen.equals(racer.get(0));
    }

}
