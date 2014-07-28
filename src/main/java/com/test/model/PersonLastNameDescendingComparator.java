package com.test.model;

import java.util.Comparator;

public class PersonLastNameDescendingComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return p2.getLastName().compareTo(p1.getLastName());
    }
}
