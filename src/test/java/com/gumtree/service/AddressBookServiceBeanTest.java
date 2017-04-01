package com.gumtree.service;


import com.gumtree.model.AddressBook;
import com.gumtree.model.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static com.gumtree.support.PersonMockFactory.buildFemalePerson;
import static com.gumtree.support.PersonMockFactory.buildMalePerson;
import static java.time.LocalDate.of;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddressBookServiceBeanTest {

    private AddressBookServiceBean sut;
    private AddressBook addressBook;
    private List<Person> personList;


    @Before
    public void before() {
        sut = new AddressBookServiceBean();
    }

    @Test
    public void shouldReturnOneMale() {

        personList = asList(buildMalePerson("some_name", of(1977, 3, 16)));
        addressBook = new AddressBook(personList);

        assertEquals(1, sut.getMale(addressBook));
    }

    @Test
    public void shouldHandleCorrectlyEmptyAddressBook() {

        personList = Collections.emptyList();
        addressBook = new AddressBook(personList);

        assertEquals(0, sut.getMale(addressBook));
    }

    @Test
    public void shouldHandleCorrectlyMixedAddressBook() {

        personList = asList(buildMalePerson("some_name", of(1977, 3, 16)),
                buildFemalePerson("some_name", of(1977, 3, 16)));
        addressBook = new AddressBook(personList);

        assertEquals(1, sut.getMale(addressBook));
    }

    @Test
    public void shouldReturnOldestSuccesfully() {

        personList = asList(buildMalePerson("some_name_2", of(1977, 3, 16)),
                buildFemalePerson("some_name_1", of(1990, 3, 16)));
        addressBook = new AddressBook(personList);

        assertTrue(sut.getOldest(addressBook).isPresent());
        assertEquals("some_name_2", sut.getOldest(addressBook).get().getName());

    }
}
