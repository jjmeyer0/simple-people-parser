package com.test.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PersonGenderDescendingThenLastNameComparatorTest {
    List<Person> expectedPeople;

    List<Person> people;

    @Before
    public void setUp() throws Exception {
        Person p = new Person();
        p.setLastName("ZAa");
        p.setGender(Gender.FEMALE);

        Person p1 = new Person();
        p1.setLastName("Zb");
        p1.setGender(Gender.FEMALE);

        Person p2 = new Person();
        p2.setLastName("A");
        p2.setGender(Gender.MALE);

        Person p3 = new Person();
        p3.setLastName("C");
        p3.setGender(Gender.MALE);

        Person p4 = new Person();
        p4.setLastName("Cz");
        p4.setGender(Gender.MALE);

        expectedPeople = Arrays.asList(p, p1, p2, p3, p4);

        people = Arrays.asList(p3, p4, p, p1, p2);
    }

    @Test
    public void doesThisComparatorProperlySort() throws Exception {
        people.sort(new PersonGenderDescendingThenLastNameComparator());
        Assert.assertEquals(expectedPeople, people);
    }
}
