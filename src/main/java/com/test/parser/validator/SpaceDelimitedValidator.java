package com.test.parser.validator;

import java.util.List;

public class SpaceDelimitedValidator extends DelimitedValidator {
    @Override
    protected int getExpectedListSize() {
        return 6;
    }

    @Override
    protected boolean isGenderValid(List<String> record) {
        String gender = record.get(3);
        return "F".equals(gender) || "M".equals(gender);
    }

    @Override
    protected boolean isMiddleInitialValidFormat(List<String> record) {
        return record.get(2).length() == 1;
    }
}
