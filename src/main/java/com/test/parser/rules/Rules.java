package com.test.parser.rules;

import com.test.model.Gender;

import java.time.LocalDate;
import java.util.List;

public interface Rules {
    String getFirstName(List<String> record);
    String getLastName(List<String> record);
    String getMiddleInitial(List<String> record);
    Gender getGender(List<String> record);
    String getFavoriteColor(List<String> record);
    LocalDate getDateOfBirth(List<String> record);
}
