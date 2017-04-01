package com.gumtree.repository;


import com.gumtree.model.AddressBook;
import com.gumtree.parser.PersonParser;
import com.gumtree.reader.DataReader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;
import java.util.stream.Stream;

import static com.gumtree.model.Gender.MALE;
import static com.gumtree.support.PersonMockFactory.buildMalePerson;
import static java.time.LocalDate.of;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LocalAddressBookRepoTest {

    LocalAddressBookRepo sut;

    @Mock
    PersonParser personParser;

    @Mock
    DataReader dataReader;

    @Before
    public void before() {
        sut = new LocalAddressBookRepo(personParser, dataReader);
    }

    @Test
    public void shouldSuccessfullyReturnAddressBook() {

        when(personParser.parsePerson(anyString())).thenReturn(of(buildMalePerson("some_name", of(1977, 3, 16))));
        when(dataReader.readData()).thenReturn(Stream.of("some_string"));

        Optional<AddressBook> result = sut.getAddressBook();

        assertTrue(result.isPresent());
        assertEquals(1, result.get().getPersonList().size());
        assertEquals("some_name", result.get().getPersonList().get(0).getName());
        assertEquals(MALE, result.get().getPersonList().get(0).getGender());
        assertEquals(of(1977, 3, 16), result.get().getPersonList().get(0).getBirthDay());

        verify(personParser).parsePerson("some_string");
        verify(dataReader).readData();
    }

    @Test
    public void shouldReturnEmptyAddressBookForEmptyPerson() {

        when(personParser.parsePerson(anyString())).thenReturn(empty());
        when(dataReader.readData()).thenReturn(Stream.of("some_string"));

        Optional<AddressBook> result = sut.getAddressBook();

        assertTrue(result.isPresent());
        assertEquals(0, result.get().getPersonList().size());

        verify(personParser).parsePerson("some_string");
        verify(dataReader).readData();
    }

}
