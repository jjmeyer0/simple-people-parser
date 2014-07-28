package com.test.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class PersonDateOfBirthAscendingComparatorTest {
    List<Person> expectedPeople;

    List<Person> people;

    @Before
    public void setUp() throws Exception {
        Person p = new Person();
        p.setDateOfBirth(LocalDate.of(1990, 4, 23));

        Person p1 = new Person();
        p1.setDateOfBirth(LocalDate.of(1990, 5, 23));

        Person p2 = new Person();
        p2.setDateOfBirth(LocalDate.of(1990, 5, 24));

        Person p3 = new Person();
        p3.setDateOfBirth(LocalDate.of(1993, 2, 12));

        Person p4 = new Person();
        p4.setDateOfBirth(LocalDate.of(1993, 3, 1));

        expectedPeople = Arrays.asList(p, p1, p2, p3, p4);

        people = Arrays.asList(p3, p4, p, p1, p2);
    }

    @Test
    public void doesThisComparatorProperlySort() throws Exception {
        people.sort(new PersonDateOfBirthAscendingComparator());
        Assert.assertEquals(expectedPeople, people);
    }
}
