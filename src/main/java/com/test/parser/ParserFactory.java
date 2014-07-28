package com.test.parser;

import com.test.model.People;
import com.test.model.Person;
import com.test.parser.mapper.DelimitedMapper;
import com.test.parser.rules.CommaDelimitedRules;
import com.test.parser.rules.PipeDelimitedRules;
import com.test.parser.rules.SpaceDelimitedRules;
import com.test.parser.validator.CommaDelimitedValidator;
import com.test.parser.validator.PipeDelimitedValidator;
import com.test.parser.validator.SpaceDelimitedValidator;
import com.test.model.People;
import com.test.model.Person;
import com.test.parser.mapper.DelimitedMapper;
import com.test.parser.rules.CommaDelimitedRules;
import com.test.parser.rules.PipeDelimitedRules;
import com.test.parser.rules.SpaceDelimitedRules;
import com.test.parser.validator.SpaceDelimitedValidator;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParserFactory {

    private static final Parser COMMA_PARSER = new DelimitedFileParser(new DelimitedMapper(new CommaDelimitedRules())
            , new CommaDelimitedValidator(), ",");
    private static final Parser PIPE_PARSER = new DelimitedFileParser(new DelimitedMapper(new PipeDelimitedRules())
            , new PipeDelimitedValidator(), "\\|");
    private static final Parser SPACE_PARSER = new DelimitedFileParser(new DelimitedMapper(new SpaceDelimitedRules())
            , new SpaceDelimitedValidator(), " ");

    public static People parse(String file, String... files) {
        if (file == null) {
            return new People();
        }

        People people = new People();

        people.getPeople().addAll(parse(getFile(file)));

        Arrays.asList(files).stream()
                .filter(f -> f != null)
                .map(f -> parse(getFile(f)))
                .forEach(e -> people.getPeople().addAll(e));

        return people;
    }

    private static File getFile(String f) {
        URL url = ParserFactory.class.getClassLoader().getResource(f);

        if (url == null) {
            throw new RuntimeException("File path, " + f + ", does not exist.");
        }

        try {
            URI uri = url.toURI();
            return new File(uri);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Person> parse(File file) {
        try (Stream<String> stream = Files.lines(file.toPath(), Charset.defaultCharset())) {
            String line = stream.map(String::trim)
                    .filter(l -> !l.trim().isEmpty())
                    .collect(Collectors.toList()).get(0);

            // I am assuming that the delimiters comma and pipe are not used anywhere in any file format.
            if (line.contains(",")) {
                return COMMA_PARSER.parse(file);
            } else if (line.contains("|")) {
                return PIPE_PARSER.parse(file);
            } else if (line.contains(" ")) {
                return SPACE_PARSER.parse(file);
            }

            throw new RuntimeException("Invalid file format for file: " + file.getPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
