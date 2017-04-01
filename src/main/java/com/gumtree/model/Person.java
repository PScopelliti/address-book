package com.gumtree.model;


import java.time.LocalDate;

public class Person {

    private final String name;
    private final Gender gender;
    private final LocalDate birthDay;

    private Person(String name,
                   Gender gender,
                   LocalDate birthDay) {
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    @Override
    public String toString() {
        return String.format("Person{name=%s, gender=%s, birthDay=%s}", name, gender, birthDay);
    }
}
