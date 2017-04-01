package com.gumtree.repository;


import com.gumtree.model.AddressBook;

import java.util.Optional;

public interface AddressBookRepo {

    Optional<AddressBook> getAddressBook();

}
