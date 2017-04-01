package com.gumtree.reader;


import com.gumtree.model.Person;
import com.gumtree.parser.PersonParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LocalFileDataReader implements DataReader {

    private String fileLocation;
    private PersonParser parser;

    public LocalFileDataReader(String fileLocation, PersonParser parser) {
        this.fileLocation = fileLocation;
        this.parser = parser;
    }

    @Override
    public List<Person> readData() {

        InputStream inputStream = this.getClass().getResourceAsStream(fileLocation);
        if (inputStream != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                return reader.lines()
                        .map(s -> parser.parsePerson(s))
                        .filter(s -> s.isPresent())
                        .map(s -> s.get())
                        .collect(Collectors.toList());
            } catch (Exception e) {
                return Collections.emptyList();
            }
        }
        return Collections.emptyList();
    }


}
