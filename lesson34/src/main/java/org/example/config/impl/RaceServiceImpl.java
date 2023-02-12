package org.example.config.impl;

import lombok.AllArgsConstructor;
import org.example.aop.MyBenchmark;
import org.example.domain.Pair;
import org.example.service.CheckService;
import org.example.service.RaceService;
import org.example.service.ResultRaceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RaceServiceImpl implements RaceService {
    private ResultRaceService resultRace;
    private CheckService check;

    @Override
    @MyBenchmark
    public List<Pair> race(List<Pair> racer) {
        int count = 1;
        List<Pair> result = new ArrayList<>();
        while (count < 6) {
            for (Pair pair : racer) {
                int speed = pair.getPairSpeed();
                speed = speed + (int) (Math.random() * 22);
                pair.setPairSpeed(speed);
            }

            try {
                Thread.sleep(6_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            result = resultRace.getResult(racer);
            check.checkWinner(count, result);
            count++;
        }
        return result;
    }
}
