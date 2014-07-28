package com.test.parser.rules;

import com.test.model.Gender;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

/**
 * The rules classes will be used to change all the different file type format information
 * to a common standard. For example, change the gender (some expect M or F while others expect
 * Male or Female) to a common format.
 */
public abstract class DelimitedRules implements Rules {
    protected abstract String getMaleRepresentation();

    protected abstract String getFemaleRepresentation();

    protected abstract String getGenderString(List<String> record);

    protected abstract String getDateFormat();

    protected abstract String getDateOfBirthRepresentation(List<String> record);

    @Override
    public Gender getGender(List<String> record) {
        String g = getGenderString(record);

        if (getMaleRepresentation().equals(g)) {
            return Gender.MALE;
        } else if (getFemaleRepresentation().equals(g)) {
            return Gender.FEMALE;
        }

        throw new RuntimeException("Invalid gender, " + g + ", in record " + Arrays.toString(record.toArray()));
    }

    @Override
    public LocalDate getDateOfBirth(List<String> record) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(getDateFormat());

        String date = getDateOfBirthRepresentation(record);

        try {
            return LocalDate.parse(date, dtf);
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Date must follow this format: " + getDateFormat()
                    + " The given date was: " + date + "");
        }
    }
}
