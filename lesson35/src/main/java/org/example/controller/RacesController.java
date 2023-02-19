package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.domain.Horse;
import org.example.domain.Pair;
import org.example.domain.Rider;
import org.example.service.MoneyService;
import org.example.service.RacesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Data
@Controller
@AllArgsConstructor
@RequestMapping(value = "/races")
public class RacesController {

    private RacesService racesServiceImpl;
    private MoneyService moneyServiceImpl;

    private static Integer balance = 100;
    private List<Pair> pairs;


    @GetMapping()
    public String home(Model model) {
        model.addAttribute("balance", balance);
        model.addAttribute("pairs", pairs);
        return "home";
    }

    @PostMapping(path = "/add-pair")
    public String addPair(Model model, @RequestParam String nameHorse, @RequestParam String nameRider) {
        pairs.add(new Pair(new Horse(nameHorse), new Rider(nameRider)));

        model.addAttribute("pairs", pairs);
        model.addAttribute("balance", balance);
        return "home";
    }

    @PostMapping(path = "/start-race")
    public String startRace(Model model, @RequestParam Integer pairNumber, @RequestParam Integer bet) {
        racesServiceImpl.start(pairs, pairNumber, bet);

        int money = moneyServiceImpl.getMoney();

        if (bet <= this.balance) {
            if (money > 0) {
                balance = balance + money;
                moneyServiceImpl.setMoney(0);
                model.addAttribute("result", "You are winner!");
            } else {
                balance = balance - bet;
                model.addAttribute("result", "You are loser!");
            }
        } else {
            model.addAttribute("result", "Insufficient funds for the bet!");
        }

        model.addAttribute("pairs", pairs);
        model.addAttribute("balance", balance);
        return "home";
    }

}
