package com.test.parser;

import com.test.model.Person;
import com.test.parser.mapper.DelimitedMapper;
import com.test.parser.rules.CommaDelimitedRules;
import com.test.parser.validator.CommaDelimitedValidator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CommaDelimitedParserTest {

    @Test
    public void emptyListWhenPassingNullToParse() throws Exception {
        Parser parser = new DelimitedFileParser(new DelimitedMapper(new CommaDelimitedRules())
                , new CommaDelimitedValidator(), ",");

        Assert.assertEquals(new ArrayList<Person>(), parser.parse(null));
    }
}
