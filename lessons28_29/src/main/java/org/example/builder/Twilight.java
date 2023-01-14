package org.example.builder;

public class Twilight {
    public static void main(String[] args) {

        Person edward = Person.builder()
                .name("Edward")
                .age(104)
                .born(1901)
                .category(Category.builder()
                        .vampire("vampire")
                        .build())
                .type("immortal")
                .build();

        Person bella = Person.builder()
                .name("Bella")
                .age(17)
                .born(1987)
                .category(Category.builder()
                        .human("human")
                        .build())
                .type("mortal")
                .build();

        Person jacob = Person.builder()
                .name("Jacob")
                .age(15)
                .born(1990)
                .category(Category.builder()
                        .werewolf("werewolf")
                        .build())
                .type("mortal")
                .build();

        System.out.println(edward);
        System.out.println(bella);
        System.out.println(jacob);
    }
}
