package com.gumtree.reader;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class LocalFileDataReader implements DataReader {

    private String fileLocation;

    public LocalFileDataReader(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    @Override
    public Stream<String> readData() {

        InputStream inputStream = this.getClass().getResourceAsStream(fileLocation);
        if (inputStream != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                return reader.lines();
            } catch (Exception e) {
                return Stream.empty();
            }
        }
        return Stream.empty();
    }


}
