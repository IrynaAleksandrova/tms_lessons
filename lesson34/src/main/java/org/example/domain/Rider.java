package org.example.domain;

import lombok.Data;
import lombok.ToString;

@Data
public class Rider {
    private String name;
    private int experience;

    public Rider(String name) {
        this.name = name;
        this.experience = (int) (Math.random() * 5) + 2;
    }
}
