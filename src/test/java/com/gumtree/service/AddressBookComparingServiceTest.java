package com.gumtree.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static com.gumtree.support.PersonMockFactory.buildMalePerson;
import static java.time.LocalDate.of;
import static java.util.Optional.of;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AddressBookComparingServiceTest {

    private AddressBookComparingService sut;

    @Mock
    private AddressBookService addressBookService;

    @Before
    public void before() {

        sut = new AddressBookComparingService(addressBookService);

        when(addressBookService.findPerson("some_person")).thenReturn(of(buildMalePerson("some_name_2", of(1977, 3, 15))));
        when(addressBookService.findPerson("some_person2")).thenReturn(of(buildMalePerson("some_name_2", of(1977, 3, 16))));
        when(addressBookService.findPerson("some_person3")).thenReturn(Optional.empty());
    }

    @After
    public void after(){
        verify(addressBookService, times(2)).findPerson(anyString());
    }

    @Test
    public void shouldReturnDifferentAgeInDaysSuccessfully() {

        Optional<Long> result = sut.getAgeDifferenceInDays("some_person", "some_person2");

        assertTrue(result.isPresent());
        assertEquals(1, result.get().longValue());

    }

    @Test
    public void shouldReturnZeroForSamePerson() {

        Optional<Long> result = sut.getAgeDifferenceInDays("some_person2", "some_person2");

        assertTrue(result.isPresent());
        assertEquals(0, result.get().longValue());
    }

    @Test
    public void shouldHandleOptionalSuccessfully() {

        Optional<Long> result = sut.getAgeDifferenceInDays("some_person3", "some_person2");

        assertFalse(result.isPresent());
    }
}
