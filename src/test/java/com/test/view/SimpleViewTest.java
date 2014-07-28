package com.test.view;

import com.test.model.Gender;
import com.test.model.Person;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SimpleViewTest {
    View view = new SimpleView();

    static List<Person> people;
    static List<Person> people1;
    static String EXPECTED_OUTPUT;

    @BeforeClass
    public static void beforeClass() throws Exception {
        people = new ArrayList<>(1);
        Person p = new Person();
        p.setLastName("Meyer");
        p.setGender(Gender.MALE);
        p.setFirstName("Josh");
        p.setDateOfBirth(LocalDate.of(1988, 9, 14));
        p.setFavoriteColor("Red");
        p.setMiddleInitial("J");
        people.add(p);

        people1 = new ArrayList<>(1);
        Person p1 = new Person();
        p1.setLastName("Smith");
        p1.setGender(Gender.FEMALE);
        p1.setFirstName("Lisa");
        p1.setDateOfBirth(LocalDate.of(1978, 8, 14));
        p1.setFavoriteColor("Blue");
        p1.setMiddleInitial("");
        people1.add(p1);

        EXPECTED_OUTPUT = "Output 1:\nMeyer Josh Male 9/14/1988 Red\n\nOutput 2:\nSmith Lisa Female 8/14/1978 Blue\n";
    }

    @Test
    public void makeSureNullIsProperlyHandled() throws Exception {
        Assert.assertEquals("", view.print(null));
    }

    @Test
    public void makeSureNullIsProperlyHandledWithMultipleLists() throws Exception {
        Assert.assertEquals("", view.print(null, null, null));
    }

    @Test
    public void doesPrintMethodReturnProperString() throws Exception {
        String out = view.print(people, people1);
        Assert.assertEquals(EXPECTED_OUTPUT, out);
    }

    @Test
    public void doesPrintMethodReturnProperStringWithNulls() throws Exception {
        String out = view.print(people, null, people1, null);
        Assert.assertEquals(EXPECTED_OUTPUT, out);
    }
}
