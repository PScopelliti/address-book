package com.gumtree.repository;


import com.gumtree.model.AddressBook;
import com.gumtree.model.Person;

import java.util.List;
import java.util.Optional;

public class LocalAddressBookRepo implements AddressBookRepo {

    private List<Person> personList;

    public LocalAddressBookRepo(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public Optional<AddressBook> getAddressBook() {

        if (personList.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(new AddressBook(personList));
    }
}
