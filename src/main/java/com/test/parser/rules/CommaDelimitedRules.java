package com.test.parser.rules;

import java.util.List;

/**
 *Comma-delimited file looks like this:
 *
 * <LastName>, <FirstName>, <Gender>, <FavoriteColor>, <DateOfBirth>
 *     <LastName>          - A basic string (cannot contain the delimiter)
 *     <FirstName>         - A basic string (cannot contain the delimiter)
 *     <Gender>            - Male or Female
 *     <FavoriteColor>     - A basic string (cannot contain the delimiter)
 *     <DateOfBirth>       - has the following format: M/d/yyyy
 *
 *     Example:
 *     Abercrombie, Neil, Male, Tan, 2/13/1943
 *     Bishop, Timothy, Male, Yellow, 4/23/1967
 *     Kelly, Sue, Female, Pink, 7/12/1959
 *
 */
public class CommaDelimitedRules extends DelimitedRules {
    public static final String DATE_FORMAT = "M/d/yyyy";

    @Override
    public String getFirstName(List<String> record) {
        return record.get(1);
    }

    @Override
    public String getLastName(List<String> record) {
        return record.get(0);
    }

    @Override
    public String getMiddleInitial(List<String> record) {
        return "";
    }

    @Override
    public String getFavoriteColor(List<String> record) {
        return record.get(3);
    }

    @Override
    protected String getMaleRepresentation() {
        return "Male";
    }

    @Override
    protected String getFemaleRepresentation() {
        return "Female";
    }

    @Override
    protected String getGenderString(List<String> record) {
        return record.get(2);
    }

    @Override
    protected String getDateFormat() {
        return DATE_FORMAT;
    }

    @Override
    protected String getDateOfBirthRepresentation(List<String> record) {
        return record.get(4);
    }
}
