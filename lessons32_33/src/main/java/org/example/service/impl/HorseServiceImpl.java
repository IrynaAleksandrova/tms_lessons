package org.example.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.domain.Pair;
import org.example.service.CheckService;
import org.example.service.HorseService;
import org.example.service.MoneyService;
import org.example.service.RaceService;
import org.example.service.ResultRaceService;

import java.util.List;
import java.util.Scanner;
@AllArgsConstructor
@NoArgsConstructor
public class HorseServiceImpl implements HorseService {
    private MoneyService moneyService;
    private RaceService raceService;
    private ResultRaceService resultRaceService;
    private CheckService check;

    @Override
    public void start(List<Pair> racer) {
        System.out.println(racer);
        System.out.println("Предпочитаемая пара от 1 до 4 ");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Предпочитаемая пара от 1 до 4 ");
        }
        int pairNumber = scanner.nextInt();
        Pair chosen = racer.get((pairNumber - 1));

        System.out.println("Ваша ставка");

        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Ваша ставка");
        }

        int rate = scanner.nextInt();
        moneyService.setMoney(rate);


        List<Pair> result = raceService.race(racer);

        boolean isWinner = resultRaceService.isWinner(result, chosen);

        if (isWinner) {
            moneyService.sumMoney();
        } else {
            moneyService.minMoney(rate);
        }
        check.checkResult(moneyService.getMoney(), isWinner);
    }
}
