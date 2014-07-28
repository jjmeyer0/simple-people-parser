package com.test.parser.mapper;

import com.test.model.Person;
import com.test.model.Person;

import java.util.List;

/**
 * Created by tperkis on 7/14/14.
 */
public interface Mapper {
    Person map(List<String> record);
}
