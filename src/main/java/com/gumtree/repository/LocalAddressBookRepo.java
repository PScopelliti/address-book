package com.gumtree.repository;


import com.gumtree.model.AddressBook;
import com.gumtree.parser.PersonParser;

import java.util.Optional;

public class LocalAddressBookRepo implements AddressBookRepo {

    private PersonParser parser;

    public LocalAddressBookRepo(PersonParser parser) {
        this.parser = parser;
    }


    @Override
    public Optional<AddressBook> getAddressBook() {
        return null;
    }
}
