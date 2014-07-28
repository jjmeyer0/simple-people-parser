package com.test.parser.validator;

import java.util.List;

public class PipeDelimitedValidator extends DelimitedValidator {
    @Override
    protected int getExpectedListSize() {
        return 6;
    }

    @Override
    protected boolean isGenderValid(List<String> record) {
        return "M".equals(record.get(3)) || "F".equals(record.get(3));
    }

    @Override
    protected boolean isMiddleInitialValidFormat(List<String> record) {
        return record.get(2).length() == 1;
    }
}
