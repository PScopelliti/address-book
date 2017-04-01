package com.gumtree.service;


import java.util.Optional;

public interface ComparingService {

    Optional<Long> getAgeDifferenceInDays(final String name1, final String name2);
}
