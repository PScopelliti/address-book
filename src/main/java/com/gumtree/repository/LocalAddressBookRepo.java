package com.gumtree.repository;


import com.gumtree.model.AddressBook;

import java.util.Optional;

public class LocalAddressBookRepo implements AddressBookRepo {

    public LocalAddressBookRepo() {

    }


    @Override
    public Optional<AddressBook> getAddressBook() {
        return null;
    }
}
