package com.gumtree.support;

import com.gumtree.model.Person;
import org.mockito.ArgumentMatcher;


public class PersonMatcher extends ArgumentMatcher<Person> {

    private final Person expected;

    public PersonMatcher(Person expected) {
        this.expected = expected;
    }

    @Override
    public boolean matches(final Object argument) {
        Person person = (Person) argument;
        return person.getName() == expected.getName() &&
                person.getGender() == expected.getGender() &&
                person.getBirthDay().compareTo(expected.getBirthDay()) == 0;
    }
}
