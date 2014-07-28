package com.test.parser.mapper;

import com.test.model.Gender;
import com.test.model.Person;
import com.test.parser.rules.Rules;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class MapperTests {

    public static final String FIRST_NAME = "fn";
    public static final String LAST_NAME = "ln";
    public static final String MIDDLE_INITIAL = "m";
    public static final Gender GENDER = Gender.MALE;
    public static final String COLOR = "red";
    public static final LocalDate DATE_OF_BIRTH = LocalDate.now();

    @Test
    public void makeSureFieldsAreProperlyMapped() throws Exception {
        Person actual = new DelimitedMapper(new Rules() {
            @Override
            public String getFirstName(List<String> record) {
                return FIRST_NAME;
            }

            @Override
            public String getLastName(List<String> record) {
                return LAST_NAME;
            }

            @Override
            public String getMiddleInitial(List<String> record) {
                return MIDDLE_INITIAL;
            }

            @Override
            public Gender getGender(List<String> record) {
                return GENDER;
            }

            @Override
            public String getFavoriteColor(List<String> record) {
                return COLOR;
            }

            @Override
            public LocalDate getDateOfBirth(List<String> record) {
                return DATE_OF_BIRTH;
            }
        }).map(Arrays.asList("", "", ""));

        Person expected = new Person();
        expected.setFirstName(FIRST_NAME);
        expected.setLastName(LAST_NAME);
        expected.setMiddleInitial(MIDDLE_INITIAL);
        expected.setGender(Gender.MALE);
        expected.setFavoriteColor(COLOR);
        expected.setDateOfBirth(DATE_OF_BIRTH);

        Assert.assertEquals(expected.getFirstName(), actual.getFirstName());
        Assert.assertEquals(expected.getLastName(), actual.getLastName());
        Assert.assertEquals(expected.getMiddleInitial(), actual.getMiddleInitial());
        Assert.assertEquals(expected.getGender(), actual.getGender());
        Assert.assertEquals(expected.getFavoriteColor(), actual.getFavoriteColor());
        Assert.assertEquals(expected.getDateOfBirth(), actual.getDateOfBirth());
    }
}
