package com.test.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PersonLastNameDescendingComparatorTest {

    List<Person> expectedPeople;

    List<Person> people;

    @Before
    public void setUp() throws Exception {
        Person p = new Person();
        p.setLastName("Za");

        Person p1 = new Person();
        p1.setLastName("ZA");

        Person p2 = new Person();
        p2.setLastName("H");

        Person p3 = new Person();
        p3.setLastName("Cz");

        Person p4 = new Person();
        p4.setLastName("C");

        expectedPeople = Arrays.asList(p, p1, p2, p3, p4);

        people = Arrays.asList(p3, p4, p, p1, p2);
    }

    @Test
    public void doesThisComparatorProperlySort() throws Exception {
        people.sort(new PersonLastNameDescendingComparator());
        Assert.assertEquals(expectedPeople, people);
    }
}
