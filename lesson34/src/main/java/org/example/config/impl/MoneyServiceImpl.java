package org.example.config.impl;

import org.example.service.MoneyService;
import org.springframework.stereotype.Service;

@Service
public class MoneyServiceImpl implements MoneyService {
    private int money;

    @Override
    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public int getMoney() {
        return money;
    }

    @Override
    public void sumMoney() {
        money = money * 2;
    }

    @Override
    public void minMoney(int count) {
        money = money - count;
    }
}
