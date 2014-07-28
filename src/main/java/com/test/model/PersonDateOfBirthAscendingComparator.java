package com.test.model;

import java.util.Comparator;

public class PersonDateOfBirthAscendingComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getDateOfBirth().compareTo(p2.getDateOfBirth());
    }
}
