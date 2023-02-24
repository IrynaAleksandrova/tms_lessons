package org.example.domain;

import lombok.Data;

@Data
public class Horse {

    private String name;
    private int speed;

    public Horse(String name) {
        this.name = name;
        this.speed = (int) (Math.random() * 11) + 11;
    }

}
