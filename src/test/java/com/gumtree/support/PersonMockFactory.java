package com.gumtree.support;


import com.gumtree.model.Person;

import java.time.LocalDate;

import static com.gumtree.model.Gender.MALE;

public class PersonMockFactory {

    private PersonMockFactory() {
    }

    public static Person buildMalePerson(String name,
                                         LocalDate dob) {
        return new Person(name, MALE, dob);
    }
}
