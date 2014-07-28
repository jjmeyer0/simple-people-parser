package com.test.parser.validator;

import java.util.List;

public class CommaDelimitedValidator extends DelimitedValidator {
    @Override
    protected int getExpectedListSize() {
        return 5;
    }

    @Override
    protected boolean isGenderValid(List<String> record) {
        return "Male".equals(record.get(2)) || "Female".equals(record.get(2));
    }

    @Override
    protected boolean isMiddleInitialValidFormat(List<String> record) {
        return true; // this format doesn't have a middle initial.
    }
}
