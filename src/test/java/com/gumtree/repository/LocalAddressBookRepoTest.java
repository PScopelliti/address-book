package com.gumtree.repository;


import com.gumtree.model.Person;
import org.junit.Test;

import java.util.List;

import static com.gumtree.support.PersonMockFactory.buildMalePerson;
import static java.time.LocalDate.of;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LocalAddressBookRepoTest {

    LocalAddressBookRepo sut;

    @Test
    public void shouldSuccessfullyReturnAddressBook() {

        List<Person> input = asList(buildMalePerson("some_name", of(1977, 3, 16)));

        sut = new LocalAddressBookRepo(input);

        assertTrue(sut.getAddressBook().isPresent());
        assertEquals(1, sut.getAddressBook().get().getPersonList().size());
    }

    @Test
    public void shouldReturnEmptyAddressBookForEmptyPersonList() {

        List<Person> input = emptyList();

        sut = new LocalAddressBookRepo(input);

        assertFalse(sut.getAddressBook().isPresent());
    }

}
