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

public class SpaceDelimitedRulesTest {
    static final Rules rules = new SpaceDelimitedRules();

    static final String FIRST_NAME = "Blaise";
    static final String LAST_NAME = "Pascal";
    static final String MIDDLE_INITIAL = "";
    static final String GENDER_MALE = "M";
    static final String COLOR_GREEN = "green";
    static final String PASCAL_BIRTH_DATE = "6-19-1623";
    static LocalDate expectedMaleBirthDate;

    static final String FEMALE_LAST_NAME = "Coleman";
    static final String FEMALE_FIRST_NAME = "Lisa";
    static final String FEMALE_MIDDLE_INITIAL = "K";
    static final String COLOR_RED = "red";
    static final String GENDER_FEMALE = "F";
    static final String FEMALE_BIRTH_DATE = "7-10-1992";
    static LocalDate expectedFemaleBirthDate;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    List<String> MALE_RECORD = Arrays.asList(
            LAST_NAME, FIRST_NAME, MIDDLE_INITIAL
            , GENDER_MALE, PASCAL_BIRTH_DATE, COLOR_GREEN
    );

    List<String> FEMALE_RECORD = Arrays.asList(
            FEMALE_LAST_NAME, FEMALE_FIRST_NAME, FEMALE_MIDDLE_INITIAL
            , GENDER_FEMALE, FEMALE_BIRTH_DATE, COLOR_RED
    );

    List<String> BAD_RECORD = Arrays.asList(null, null, null, "male", "", "");

    @BeforeClass
    public static void setUp() throws Exception {
        expectedMaleBirthDate = LocalDate.of(1623, 6, 19);
        expectedFemaleBirthDate = LocalDate.of(1992, 7, 10);
    }

    @Test
    public void makeSureFirstNameIsMappedProperly() throws Exception {
        Assert.assertEquals(FIRST_NAME, rules.getFirstName(MALE_RECORD));
        Assert.assertEquals(FEMALE_FIRST_NAME, rules.getFirstName(FEMALE_RECORD));
    }

    @Test
    public void makeSureLastNameIsMappedProperly() throws Exception {
        Assert.assertEquals(LAST_NAME, rules.getLastName(MALE_RECORD));
        Assert.assertEquals(FEMALE_LAST_NAME, rules.getLastName(FEMALE_RECORD));
    }

    @Test
    public void makeSureMiddleInitialIsMappedProperly() throws Exception {
        Assert.assertEquals(MIDDLE_INITIAL, rules.getMiddleInitial(MALE_RECORD));
        Assert.assertEquals(FEMALE_MIDDLE_INITIAL, rules.getMiddleInitial(FEMALE_RECORD));
    }

    @Test
    public void makeSureFavoriteColorIsMappedProperly() throws Exception {
        Assert.assertEquals(COLOR_GREEN, rules.getFavoriteColor(MALE_RECORD));
        Assert.assertEquals(COLOR_RED, rules.getFavoriteColor(FEMALE_RECORD));
    }

    @Test
    public void makeSureGenderIsProperlyMapped() throws Exception {
        Assert.assertEquals(Gender.MALE, rules.getGender(MALE_RECORD));
        Assert.assertEquals(Gender.FEMALE, rules.getGender(FEMALE_RECORD));
    }

    @Test
    public void makeSureDateProperlyMaps() throws Exception {
        Assert.assertEquals(expectedMaleBirthDate.getDayOfMonth(), rules.getDateOfBirth(MALE_RECORD).getDayOfMonth());
        Assert.assertEquals(expectedMaleBirthDate.getMonth(), rules.getDateOfBirth(MALE_RECORD).getMonth());
        Assert.assertEquals(expectedMaleBirthDate.getYear(), rules.getDateOfBirth(MALE_RECORD).getYear());

        Assert.assertEquals(expectedFemaleBirthDate.getDayOfMonth(), rules.getDateOfBirth(FEMALE_RECORD).getDayOfMonth());
        Assert.assertEquals(expectedFemaleBirthDate.getMonth(), rules.getDateOfBirth(FEMALE_RECORD).getMonth());
        Assert.assertEquals(expectedFemaleBirthDate.getYear(), rules.getDateOfBirth(FEMALE_RECORD).getYear());
    }

    @Test
    public void makeSureProperErrorOccursWithInvalidGender() {
        expectedException.expectMessage("Invalid gender, ");
        rules.getGender(BAD_RECORD);
    }

    @Test
    public void dateOfBirthThrowsExceptionWithBadDateFormat() throws Exception {
        expectedException.expectMessage("Date must follow this format: ");
        rules.getDateOfBirth(BAD_RECORD);
    }
}
