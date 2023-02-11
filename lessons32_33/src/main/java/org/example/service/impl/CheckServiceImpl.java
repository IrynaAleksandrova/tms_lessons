package org.example.service.impl;

import org.example.domain.Pair;
import org.example.service.CheckService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CheckServiceImpl implements CheckService {
    @Override
    public void checkWinner(int race, List<Pair> racer) {
        System.out.println("Забег " + race);

        for (int i = 0; i < racer.size(); i++) {
            System.out.println((i + 1) + " место " + racer.get(i));
        }
    }

    @Override
    public void checkResult(int money, boolean isWinner) {
        if (isWinner) {
            System.out.println("Вы выиграли!");
            System.out.println("Ваш выигрыш составил " + money + "$");

        } else {
            System.out.println("Вы проиграли");
            System.out.println("Вы получите " + money + "$");
        }
    }
}
