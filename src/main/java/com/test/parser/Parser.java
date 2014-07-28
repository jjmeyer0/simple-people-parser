package com.test.parser;

import com.test.model.Person;
import com.test.model.Person;

import java.io.File;
import java.util.List;

public interface Parser {
    List<Person> parse(File input);
}
