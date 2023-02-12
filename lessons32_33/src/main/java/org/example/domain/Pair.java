package org.example.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Pair {
    private Horse horse;
    private Rider rider;
    private int pairSpeed;

    public Pair(Horse horse, Rider rider) {

        this.horse = horse;
        this.rider = rider;
        pairSpeed = horse.getSpeed() + rider.getExperience();

    }
}
