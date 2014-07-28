package com.test.parser.validator;

import java.util.List;

/**
 * This class defines basic information on what must be defined for each validator. We
 * expect that each validator checks the list size, whether the gender is valid, and
 * lastly if the middle initial is a valid format. These are just basic sanity checks.
 */
public abstract class DelimitedValidator implements Validator {

    protected abstract int getExpectedListSize();

    protected abstract boolean isGenderValid(List<String> record);

    protected abstract boolean isMiddleInitialValidFormat(List<String> record);

    @Override
    public boolean isValid(List<String> record) {
        return record != null && record.size() == getExpectedListSize()
                && isGenderValid(record) && isMiddleInitialValidFormat(record);
    }
}
