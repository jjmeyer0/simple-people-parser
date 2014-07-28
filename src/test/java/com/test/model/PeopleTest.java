package com.test.model;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class PeopleTest {
    static People people;
    static Person p;
    static Person p1;
    static Person p2;
    static Person p3;
    static Person p4;

    @BeforeClass
    public static void before() throws Exception {
        people = new People();

        p = new Person();
        p.setLastName("Meyer");
        p.setGender(Gender.MALE);
        p.setFirstName("Josh");
        p.setDateOfBirth(LocalDate.of(1988, 9, 14));
        p.setFavoriteColor("Red");
        p.setMiddleInitial("J");
        people.getPeople().add(p);

        p1 = new Person();
        p1.setLastName("Smith");
        p1.setGender(Gender.FEMALE);
        p1.setFirstName("Lisa");
        p1.setDateOfBirth(LocalDate.of(1978, 8, 14));
        p1.setFavoriteColor("Blue");
        p1.setMiddleInitial("");
        people.getPeople().add(p1);

        p2 = new Person();
        p2.setLastName("Coleman");
        p2.setGender(Gender.FEMALE);
        p2.setFirstName("Terrin");
        p2.setDateOfBirth(LocalDate.of(1992, 12, 23));
        p2.setFavoriteColor("green");
        p2.setMiddleInitial("C");
        people.getPeople().add(p2);

        p3 = new Person();
        p3.setLastName("Miller");
        p3.setGender(Gender.MALE);
        p3.setFirstName("Dan");
        p3.setDateOfBirth(LocalDate.of(1966, 9, 1));
        p3.setFavoriteColor("yellow");
        p3.setMiddleInitial("");
        people.getPeople().add(p3);

        p4 = new Person();
        p4.setLastName("Meir");
        p4.setGender(Gender.FEMALE);
        p4.setFirstName("Nicole");
        p4.setDateOfBirth(LocalDate.of(1958, 2, 14));
        p4.setFavoriteColor("tan");
        p4.setMiddleInitial("");
        people.getPeople().add(p4);
    }

    @Test
    public void makeSureGetPeopleIsNeverNull() throws Exception {
        People people = new People();

        Assert.assertNotNull(people.getPeople());
    }

    @Test
    public void isSortedByGenderLastNameWorking() throws Exception {
        List<Person> expected = Arrays.asList(p2, p4, p1, p, p3);
        Assert.assertEquals(expected, people.getSortedByGenderDescendingThenLastName());
    }

    @Test
    public void sortedByBirthAscending() throws Exception {
        List<Person> expected = Arrays.asList(p4, p3, p1, p, p2);
        Assert.assertEquals(expected, people.getPeopleSortedByBirthAscending());
    }

    @Test
    public void sortedByLastNameDescending() throws Exception {
        List<Person> expected = Arrays.asList(p1, p3, p, p4, p2);
        Assert.assertEquals(expected, people.getPeopleSortedByLastNameDescending());
    }
}
