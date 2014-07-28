package com.test.parser.rules;

import java.util.List;

/**
 * Space-delimited file looks like this:
 * <LastName> <FirstName> <MiddleInitial> <Gender> <DateOfBirth> <FavoriteColor>
 *     <LastName>          - A basic string (cannot contain the delimiter)
 *     <FirstName>         - A basic string (cannot contain the delimiter)
 *     <MiddleInitial>     - A single character (cannot contain the delimiter)
 *     <Gender>            - A single character: M for Male and F for Female
 *     <FavoriteColor>     - A basic string (cannot contain the delimiter)
 *     <DateOfBirth>       - has the following format: M-d-yyyy
 *
 *     Example:
 *     Kournikova Anna F F 6-3-1975 Red
 *     Hingis Martina M F 4-2-1979 Green
 *     Seles Monica H F 12-2-1973 Black
 */
public class SpaceDelimitedRules extends DelimitedRules {

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
        return record.get(5);
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
        return record.get(4);
    }
}
