package com.test.parser;

import com.test.parser.mapper.DelimitedMapper;
import com.test.parser.rules.CommaDelimitedRules;
import com.test.parser.validator.CommaDelimitedValidator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DelimitedFileParserTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void makeSureThatMapperIsNullErrorOccurs() throws Exception {
        expectedException.expectMessage("You must supply a mapper.");
        new DelimitedFileParser(null, new CommaDelimitedValidator(), ",").parse(null);
    }

    @Test
    public void makeSureThatValidatorIsNullErrorOccurs() throws Exception {
        expectedException.expectMessage("A validator must be supplied.");
        new DelimitedFileParser(new DelimitedMapper(new CommaDelimitedRules()), null, ",").parse(null);
    }

    @Test
    public void makeSureThatDelimiterEmptyIsNullErrorOccurs() throws Exception {
        expectedException.expectMessage("A valid delimiter must be supplied.");
        new DelimitedFileParser(new DelimitedMapper(new CommaDelimitedRules()), new CommaDelimitedValidator(), "").parse(null);
    }

    @Test
    public void makeSureThatDelimiterNullIsNullErrorOccurs() throws Exception {
        expectedException.expectMessage("A valid delimiter must be supplied.");
        new DelimitedFileParser(new DelimitedMapper(new CommaDelimitedRules()), new CommaDelimitedValidator(), null).parse(null);
    }
}
