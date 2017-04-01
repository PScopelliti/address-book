package com.gumtree.reader;


import com.gumtree.model.Person;
import com.gumtree.parser.PersonParser;
import com.gumtree.support.PersonMatcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static com.gumtree.support.PersonMockFactory.buildMalePerson;
import static java.time.LocalDate.of;
import static java.util.Optional.of;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LocalFileDataReaderTest {

    private DataReader sut;

    @Mock
    PersonParser personParser;


    @Before
    public void before() {
        when(personParser.parsePerson(anyString())).thenReturn(of(buildMalePerson("Bill McKnight", of(1977, 3, 16))));
    }

    @Test
    public void shouldReturnEmptyListForNonExistingFile() {

        sut = new LocalFileDataReader("/wrongname", personParser);

        List<Person> list = sut.readData();

        assertEquals(0, list.size());
    }

    @Test
    public void shouldReadInputFile() throws Exception {

        sut = new LocalFileDataReader("/valid-address-book.txt", personParser);

        List<Person> list = sut.readData();

        assertEquals(5, list.size());

        assertThat(buildMalePerson("Bill McKnight", of(1977, 3, 16)), new PersonMatcher(list.get(0)));
        assertThat(buildMalePerson("Bill McKnight", of(1977, 3, 16)), new PersonMatcher(list.get(1)));
        assertThat(buildMalePerson("Bill McKnight", of(1977, 3, 16)), new PersonMatcher(list.get(2)));
        assertThat(buildMalePerson("Bill McKnight", of(1977, 3, 16)), new PersonMatcher(list.get(3)));
        assertThat(buildMalePerson("Bill McKnight", of(1977, 3, 16)), new PersonMatcher(list.get(4)));
    }
}
