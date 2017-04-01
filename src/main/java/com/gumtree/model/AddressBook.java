package com.gumtree.model;


import java.util.List;

public class AddressBook {

    private List<Person> personList;

    public AddressBook(List<Person> personList) {
        this.personList = personList;
    }

    public List<Person> getPersonList() {
        return personList;
    }
}
