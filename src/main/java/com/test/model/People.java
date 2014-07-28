package com.test.model;

import java.util.ArrayList;
import java.util.List;

public class People {
    private List<Person> people;

    public List<Person> getPeople() {
        if (people == null) {
            people = new ArrayList<>();
        }

        return people;
    }

    public List<Person> getSortedByGenderDescendingThenLastName() {
        List<Person> people = new ArrayList<>(getPeople());
        people.sort(new PersonGenderDescendingThenLastNameComparator());
        return people;
    }

    public List<Person> getPeopleSortedByBirthAscending() {
        List<Person> people = new ArrayList<>(getPeople());
        people.sort(new PersonDateOfBirthAscendingComparator());
        return people;
    }

    public List<Person> getPeopleSortedByLastNameDescending() {
        List<Person> people = new ArrayList<>(getPeople());
        people.sort(new PersonLastNameDescendingComparator());
        return people;
    }
}
