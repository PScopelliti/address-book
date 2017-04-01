package com.gumtree.repository;


import com.gumtree.model.AddressBook;
import com.gumtree.parser.PersonParser;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Optional;

import static com.gumtree.support.PersonMockFactory.buildMalePerson;
import static java.time.LocalDate.of;
import static java.util.Optional.of;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class LocalAddressBookRepoTest {

    LocalAddressBookRepo sut;

    @Mock
    PersonParser personParser;

    @Before
    public void before() {
        sut = new LocalAddressBookRepo(personParser);
    }

    @Test
    public void test() {

        when(personParser.parsePerson(anyString())).thenReturn(of(buildMalePerson("some_name", of(1977, 3, 16))));

        Optional<AddressBook> result = sut.getAddressBook();

        assertTrue(result.isPresent());
    }

}
