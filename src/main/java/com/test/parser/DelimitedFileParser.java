package com.test.parser;

import com.test.model.Person;
import com.test.parser.mapper.DelimitedMapper;
import com.test.parser.mapper.Mapper;
import com.test.parser.validator.Validator;
import com.test.model.Person;
import com.test.parser.validator.Validator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This is an abstract class that will be used to parse files with a delimiter.
 * When parsing the following will be done:
 *      1. is will validate each record. If the record isn't valid an
 *         error will be thrown; otherwise, map the record
 *      2. It will then map the given input.
 *
 * Please see the mapper and validator classes for more information.
 */
public class DelimitedFileParser implements Parser {
    private final Mapper mapper;
    private final Validator validator;
    private final String delimiter;

    public DelimitedFileParser(Mapper mapper, Validator validator, String delimiter) {
        this.mapper = mapper;
        this.validator = validator;
        this.delimiter = delimiter;
    }

    @Override
    public List<Person> parse(File input) {
        if (mapper == null) throw new RuntimeException("You must supply a mapper.");
        if (validator == null) throw new RuntimeException("A validator must be supplied.");
        if (delimiter == null || "".equals(delimiter)) throw new RuntimeException("A valid delimiter must be supplied.");

        if (input == null) {
            return new ArrayList<>();
        }

        try (Stream<String> stream = Files.lines(input.toPath())) {
            return stream.filter(l -> !l.isEmpty()).map(s -> {
                List<String> record = Arrays.asList(s.split(delimiter))
                        .stream().map(String::trim).collect(Collectors.toList());

                if (validator.isValid(record)) {
                    return mapper.map(record);
                }

                throw new RuntimeException("The following input does not have a valid format. " + input.getPath());
            }).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
