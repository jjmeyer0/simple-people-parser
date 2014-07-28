package com.test.model;

import java.util.Comparator;

public class PersonGenderDescendingThenLastNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        int i = p2.getGender().compareTo(p1.getGender());
        return i == 0 ? p1.getLastName().compareTo(p2.getLastName()) : i;
    }
}
