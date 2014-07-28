package com.test.parser.validator;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SpaceDelimiterValidatorTest {
    static Validator validator = new SpaceDelimitedValidator();

    @Test
    public void makeSureTestProperlyCheckGender() throws Exception {
        List<String> record = Arrays.asList(null, null, "J", "F", null, null);
        Assert.assertTrue(validator.isValid(record));

        List<String> record1 = Arrays.asList(null, null, "J", "M", null, null);
        Assert.assertTrue(validator.isValid(record1));
    }

    @Test
    public void makeSureInvalidMiddleInitialFails() throws Exception {
        List<String> record1 = Arrays.asList(null, null, "Jf", "F", null, null);
        Assert.assertFalse(validator.isValid(record1));

        List<String> record2 = Arrays.asList(null, null, "", "F", null, null);
        Assert.assertFalse(validator.isValid(record2));
    }

    @Test
    public void makeSureInvalidGenderFails() throws Exception {
        List<String> record = Arrays.asList(null, null, "D", "Fd", null, null);
        Assert.assertFalse(validator.isValid(record));

        List<String> record1 = Arrays.asList(null, null, "J", "", null, null);
        Assert.assertFalse(validator.isValid(record1));
    }

    @Test
    public void makeSureValidatorHandlesLengthCheckProperly() throws Exception {
        List<String> record = Arrays.asList();
        Assert.assertFalse(validator.isValid(record));

        Assert.assertFalse(validator.isValid(null));
    }
}
