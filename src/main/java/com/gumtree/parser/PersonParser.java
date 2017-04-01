package com.gumtree.parser;


import com.gumtree.model.Person;

import java.util.Optional;

public interface PersonParser {

    String DELIMITER = ",";

    Optional<Person> parsePerson(String personStr);
}
