package com.test.parser;

import com.test.model.People;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ParserFactoryTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void parseInvalidFileThrowsFilePathDoesNotExist() throws Exception {
        expectedException.expectMessage("File path, ");
        ParserFactory.parse("no-file.txt");
    }

    @Test
    public void atLeastOneFileMustBeProvided() throws Exception {
        People p = ParserFactory.parse((String) null);
        Assert.assertTrue(p.getPeople().size() == 0);
    }
}
