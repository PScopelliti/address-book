package com.gumtree.parser;


import com.gumtree.model.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static com.gumtree.model.Gender.MALE;
import static java.time.LocalDate.of;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LocalParserPersonTest {

    private LocalParserPerson sut;

    @Before
    public void before() {
        sut = new LocalParserPerson();
    }

    @Test
    public void shouldBuildPersonSuccessfully() {

        Optional<Person> result = sut.parsePerson("Bill McKnight, Male, 16/03/77");

        assertTrue(result.isPresent());
        assertEquals("Bill McKnight", result.get().getName());
        assertEquals(MALE, result.get().getGender());
        assertEquals(of(1977, 3, 16), result.get().getBirthDay());
    }

    @Test
    public void shouldReturnEmptyForMalformedInput() {

        Optional<Person> result = sut.parsePerson("Bill McKnight, Male 16/03/77");

        assertFalse(result.isPresent());
    }

    @Test
    public void shouldHandleCorrectlyOldBirthDate() {

        Optional<Person> result = sut.parsePerson("Bill McKnight, Male, 16/03/08");

        assertTrue(result.isPresent());
        assertEquals("Bill McKnight", result.get().getName());
        assertEquals(MALE, result.get().getGender());
        assertEquals(of(1908, 3, 16), result.get().getBirthDay());
    }
}
