package com.test.parser.rules;

import java.util.List;

/**
 * Pipe-delimited files have the following format:
 *
 * <LastName> | <FirstName> | <MiddleInitial> | <Gender> | <FavoriteColor> | <DateOfBirth>
 *     <LastName>          - A basic string (cannot contain the delimiter)
 *     <FirstName>         - A basic string (cannot contain the delimiter)
 *     <MiddleInitial>     - A single character (cannot contain the delimiter)
 *     <Gender>            - M for Male and F for Female
 *     <FavoriteColor>     - A basic string (cannot contain the delimiter)
 *     <DateOfBirth>       - has the following format: M-d-yyyy
 *
 *     Example:
 *     Smith | Steve | D | M | Red | 3-3-1985
 *     Bonk | Radek | S | M | Green | 6-3-1975
 *     Bouillon | Francis | G | M | Blue | 6-3-1975
 */
public class PipeDelimitedRules extends DelimitedRules {

    private static final String DATE_FORMAT = "M-d-yyyy";

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
        return record.get(2);
    }

    @Override
    public String getFavoriteColor(List<String> record) {
        return record.get(4);
    }

    @Override
    protected String getMaleRepresentation() {
        return "M";
    }

    @Override
    protected String getFemaleRepresentation() {
        return "F";
    }

    @Override
    protected String getGenderString(List<String> record) {
        return record.get(3);
    }

    @Override
    protected String getDateFormat() {
        return DATE_FORMAT;
    }

    @Override
    public String getDateOfBirthRepresentation(List<String> record) {
        return record.get(5);
    }
}
