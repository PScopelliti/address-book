package com.gumtree.service;


import com.gumtree.model.AddressBook;
import com.gumtree.model.Gender;

import static com.gumtree.model.Gender.MALE;

public class AddressBookServiceBean implements AddressBookService {

    @Override
    public long getMale(AddressBook addressBook) {
        return getGenderCount(MALE, addressBook);
    }

    @Override
    public String getOldest(AddressBook addressBook) {
        return null;
    }


    /**
     * Finds total number of people of given gender.
     *
     * @param gender gender
     * @return number of people
     */
    private long getGenderCount(Gender gender, AddressBook addressBook) {
        return addressBook
                .getPersonList()
                .stream()
                .filter(p -> gender.equals(p.getGender()))
                .count();
    }
}
