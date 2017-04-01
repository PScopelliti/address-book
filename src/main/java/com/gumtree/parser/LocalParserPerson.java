package com.gumtree.parser;


import com.gumtree.model.Gender;
import com.gumtree.model.Person;

import java.time.LocalDate;
import java.util.Optional;

import static java.time.LocalDate.parse;
import static java.time.format.DateTimeFormatter.ofPattern;

public class LocalParserPerson implements PersonParser {

    private static final String DATE_PATTERN = "dd/MM/yy";

    @Override
    public Optional<Person> parsePerson(final String personStr) {
        try {

            String[] splitArray = personStr.split(DELIMITER);
            String name = splitArray[0].trim();
            Gender gender = Gender.valueOf(splitArray[1].trim().toUpperCase());

            LocalDate bDay = parse(splitArray[2].trim(), ofPattern(DATE_PATTERN)).minusYears(100);
            return Optional.of(new Person(name, gender, bDay));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

}
