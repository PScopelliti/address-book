package com.gumtree.service;


import com.gumtree.model.AddressBook;

public interface AddressBookService {

    long getMale(AddressBook addressBook);

    String getOldest(AddressBook addressBook);

}
