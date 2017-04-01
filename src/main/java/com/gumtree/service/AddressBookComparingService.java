package com.gumtree.service;


import com.gumtree.model.Person;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

public class AddressBookComparingService implements ComparingService {

    private AddressBookService addressBookService;

    public AddressBookComparingService(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    @Override
    public Optional<Long> getAgeDifferenceInDays(final String name1, final String name2) {

        Optional<Person> person1 = addressBookService.findPerson(name1);
        Optional<Person> person2 = addressBookService.findPerson(name2);

        if (person1.isPresent() && person2.isPresent()) {
            LocalDate birthday1 = person1.get().getBirthDay();
            LocalDate birthday2 = person2.get().getBirthDay();
            long days = ChronoUnit.DAYS.between(birthday1, birthday2);
            return Optional.of(days);
        } else {
            return Optional.empty();
        }
    }
}
