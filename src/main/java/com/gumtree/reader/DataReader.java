package com.gumtree.reader;


import java.util.stream.Stream;

public interface DataReader {

    Stream<String> readData();
}
