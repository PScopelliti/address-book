package com.gumtree.service;


import com.gumtree.model.Person;

import java.util.Optional;

public interface AddressBookService {

    long getMale();

    Optional<Person> getOldest();

    Optional<Person> findPerson(String name);

}
