package com.test.parser.mapper;

import com.test.model.Person;
import com.test.parser.rules.Rules;
import com.test.parser.rules.Rules;

import java.util.List;

public class DelimitedMapper implements Mapper {
    private final Rules rules;

    public DelimitedMapper(Rules rules) {
        this.rules = rules;
    }

    @Override
    public Person map(List<String> record) {
        Person p = new Person();

        p.setDateOfBirth(rules.getDateOfBirth(record));
        p.setFavoriteColor(rules.getFavoriteColor(record));
        p.setFirstName(rules.getFirstName(record));
        p.setGender(rules.getGender(record));
        p.setLastName(rules.getLastName(record));
        p.setMiddleInitial(rules.getMiddleInitial(record));

        return p;
    }
}
