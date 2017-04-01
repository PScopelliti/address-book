package com.gumtree.service;


import com.gumtree.model.AddressBook;
import com.gumtree.model.Gender;
import com.gumtree.model.Person;

import java.util.Comparator;
import java.util.Optional;

import static com.gumtree.model.Gender.MALE;

public class AddressBookServiceBean implements AddressBookService {

    private AddressBook addressBook;

    public AddressBookServiceBean(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    @Override
    public long getMale() {
        return getGenderCount(MALE);
    }

    @Override
    public Optional<Person> getOldest() {

        return addressBook
                .getPersonList()
                .stream()
                .min(Comparator.comparing(Person::getBirthDay));
    }

    @Override
    public Optional<Person> findPerson(String name) {
        return addressBook
                .getPersonList()
                .stream()
                .filter(p -> p.getName().equals(name))
                .findFirst();
    }

    /**
     * Finds total number of people of given gender.
     *
     * @param gender gender
     * @return number of people
     */
    private long getGenderCount(Gender gender) {
        return addressBook
                .getPersonList()
                .stream()
                .filter(p -> gender.equals(p.getGender()))
                .count();
    }
}
