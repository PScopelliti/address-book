package com.gumtree.repository;


import com.gumtree.model.AddressBook;
import com.gumtree.model.Person;
import com.gumtree.parser.PersonParser;
import com.gumtree.reader.DataReader;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LocalAddressBookRepo implements AddressBookRepo {

    private PersonParser parser;
    private DataReader dataReader;

    public LocalAddressBookRepo(PersonParser parser, DataReader dataReader) {
        this.parser = parser;
        this.dataReader = dataReader;
    }


    @Override
    public Optional<AddressBook> getAddressBook() {

        List<Person> personList = dataReader.readData()
                .map(s -> parser.parsePerson(s))
                .filter(s -> s.isPresent())
                .map(s -> s.get())
                .collect(Collectors.toList());

        return Optional.of(new AddressBook(personList));

    }
}
