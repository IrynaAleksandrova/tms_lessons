package org.example.service.impl;

import lombok.AllArgsConstructor;
import org.example.domain.Pair;
import org.example.service.MoneyService;
import org.example.service.RacesService;
import org.example.service.ResultService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RacesServiceImpl implements RacesService {

    private MoneyService moneyServiceImpl;
    private ResultService resultService;


    @Override
    public List<Pair> race(List<Pair> racer) {
        int count = 1;
        while (count < 6) {
            for (Pair pair : racer) {
                int speed = pair.getPairSpeed();
                speed = speed + (int) (Math.random() * 22);
                pair.setPairSpeed(speed);
            }
            count++;
        }
        return racer;
    }

    @Override
    public void start(List<Pair> racers, Integer pairNumber, Integer money) {
        Pair chosen = racers.get((pairNumber - 1));

        moneyServiceImpl.setMoney(money);

        List<Pair> result = race(racers);

        boolean isWinner = resultService.isWinner(result, chosen);

        if (isWinner) {
            moneyServiceImpl.sumMoney();
        } else {
            moneyServiceImpl.minMoney(money);
        }
    }

}
