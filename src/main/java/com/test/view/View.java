package com.test.view;

import com.test.model.Person;
import com.test.model.Person;

import java.util.List;

public interface View {
    String print(List<Person> records);

    String print(List<Person> record, List<Person>... records);
}
