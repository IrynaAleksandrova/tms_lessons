package org.example.config;

import org.example.domain.Horse;
import org.example.domain.Pair;
import org.example.domain.Rider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public Horse horseBlack() {
        return new Horse("Black");
    }

    @Bean
    public Horse horseBob() {
        return new Horse("Bob");
    }

    @Bean
    public Horse horseRed() {
        return new Horse("Redk");
    }

    @Bean
    public Rider riderMike() {
        return new Rider("Mike");
    }

    @Bean
    public Rider riderWill() {
        return new Rider("Will");
    }

    @Bean
    public Rider riderJoe() {
        return new Rider("Joe");
    }

    @Bean
    public Pair pair1(@Qualifier("horseBlack") Horse horse, @Qualifier("riderMike") Rider rider) {
        return new Pair(horse, rider);
    }

    @Bean
    public Pair pair2(@Qualifier("horseBob") Horse horse, @Qualifier("riderWill") Rider rider) {
        return new Pair(horse, rider);
    }

    @Bean
    public Pair pair3(@Qualifier("horseRed") Horse horse, @Qualifier("riderJoe") Rider rider) {
        return new Pair(horse, rider);
    }
}
