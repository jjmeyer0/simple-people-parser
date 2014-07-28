package com.test.model;

/**
 * Created by tperkis on 7/14/14.
 */
public enum Gender {
    MALE("Male"), FEMALE("Female");

    private String value;

    private Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
