package com.gumtree.service;


import com.gumtree.model.AddressBook;
import com.gumtree.model.Person;

import java.util.Optional;

public interface AddressBookService {

    long getMale(AddressBook addressBook);

    Optional<Person> getOldest(AddressBook addressBook);

}
