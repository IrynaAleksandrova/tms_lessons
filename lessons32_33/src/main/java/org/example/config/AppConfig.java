package org.example.config;

import org.example.domain.Horse;
import org.example.domain.Pair;
import org.example.domain.Rider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    Horse horseBlack() {
        return new Horse("Black");
    }

    @Bean
    Horse horseBob() {
        return new Horse("Bob");
    }

    @Bean
    Horse horseRed() {
        return new Horse("Redk");
    }

    @Bean
    Rider riderMike() {
        return new Rider("Mike");
    }

    @Bean
    Rider riderWill() {
        return new Rider("Will");
    }

    @Bean
    Rider riderJoe() {
        return new Rider("Joe");
    }

    @Bean
    Pair pair1(@Qualifier("horseBlack") Horse horse, @Qualifier("riderMike") Rider rider) {
        return new Pair(horse, rider);
    }

    @Bean
    Pair pair2(@Qualifier("horseBob") Horse horse, @Qualifier("riderWill") Rider rider) {
        return new Pair(horse, rider);
    }

    @Bean
    Pair pair3(@Qualifier("horseRed") Horse horse, @Qualifier("riderJoe") Rider rider) {
        return new Pair(horse, rider);
    }
}
