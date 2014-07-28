package com.test.parser.rules;

import com.test.model.Gender;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class CommaDelimitedRulesTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private static final String LAST_NAME = "Meyer";
    private static final String FIRST_NAME = "Josh";
    private static final String MALE = "Male";
    private static final String FEMALE = "Female";
    private static final String COLOR = "Red";
    private static final String DATE_OF_BIRTH = "9/14/1988";

    private static LocalDate expectedDate;

    private static final List<String> RECORD_MALE = Arrays.asList(
            LAST_NAME, FIRST_NAME, MALE, COLOR, DATE_OF_BIRTH
    );

    private static final List<String> RECORD_FEMALE = Arrays.asList(
            LAST_NAME, FIRST_NAME, FEMALE, COLOR, DATE_OF_BIRTH
    );

    private static final List<String> BAD_RECORD = Arrays.asList(
            null, null, "f", null, "1988-09-14"
    );

    private static final Rules rules = new CommaDelimitedRules();

    @BeforeClass
    public static void beforeClass() throws Exception {
        expectedDate = LocalDate.of(1988, 9, 14);
    }

    @Test
    public void doesMiddleInitialAlwaysReturnNull() throws Exception {
        Assert.assertEquals("", rules.getMiddleInitial(null));
        Assert.assertEquals("", rules.getMiddleInitial(RECORD_MALE));
    }

    @Test
    public void isGenderRepresentationCorrect() throws Exception {
        Assert.assertEquals(Gender.MALE, rules.getGender(RECORD_MALE));
    }

    @Test
    public void isFemaleRepresentationCorrect() throws Exception {
        Assert.assertEquals(Gender.FEMALE, rules.getGender(RECORD_FEMALE));
    }

    @Test
    public void isProperFirstNameReturned() throws Exception {
        Assert.assertEquals(FIRST_NAME, rules.getFirstName(RECORD_MALE));
    }

    @Test
    public void isProperLastNameReturned() throws Exception {
        Assert.assertEquals(LAST_NAME, rules.getLastName(RECORD_MALE));
    }

    @Test
    public void isProperDateReturned() throws Exception {
        LocalDate actual = rules.getDateOfBirth(RECORD_MALE);
        Assert.assertEquals(expectedDate.getYear(), actual.getYear());
        Assert.assertEquals(expectedDate.getMonth(), actual.getMonth());
        Assert.assertEquals(expectedDate.getDayOfMonth(), actual.getDayOfMonth());
    }

    @Test
    public void isColorProperlyReturned() throws Exception {
        Assert.assertEquals(COLOR, rules.getFavoriteColor(RECORD_MALE));
    }

    @Test
    public void dateOfBirthThrowsExceptionWithBadDateFormat() throws Exception {
        expectedException.expectMessage("Date must follow this format: ");
        rules.getDateOfBirth(BAD_RECORD);
    }

    @Test
    public void invalidGenderExpected() throws Exception {
        expectedException.expectMessage("Invalid gender, ");
        rules.getGender(BAD_RECORD);
    }
}
