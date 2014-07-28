package com.test;

import com.test.model.People;
import com.test.parser.ParserFactory;
import com.test.view.SimpleView;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.net.URI;
import java.nio.file.Files;

public class MainTestTest {

    @SuppressWarnings({"ConstantConditions", "unchecked"})
    @Test
    public void endToEndTest() throws Exception {
        People people = ParserFactory.parse("input_files/comma.txt", "input_files/pipe.txt", "input_files/space.txt");

        String actual = new SimpleView().print(
                people.getSortedByGenderDescendingThenLastName()
                , people.getPeopleSortedByBirthAscending()
                , people.getPeopleSortedByLastNameDescending()
        ).trim();

        URI uri = MainTestTest.class.getClassLoader().getResource("output_files/model_output.txt").toURI();
        String expected = Files.lines(new File(uri).toPath()).reduce("", (s,ss) -> s + ss + "\n").trim();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void doesLargeFileParse() throws Exception {
        People people = ParserFactory.parse(
                "input_files/large_file.txt", "input_files/large_file.txt", "input_files/large_file.txt"
                , "input_files/large_file.txt", "input_files/large_file.txt", "input_files/large_file.txt"
                , "input_files/large_file.txt", "input_files/large_file.txt", "input_files/large_file.txt"
                , "input_files/large_file.txt", "input_files/large_file.txt", "input_files/large_file.txt"
                , "input_files/large_file.txt", "input_files/large_file.txt", "input_files/large_file.txt"
                , "input_files/large_file.txt", "input_files/large_file.txt", "input_files/large_file.txt"
                , "input_files/large_file.txt", "input_files/large_file.txt", "input_files/large_file.txt"
                , "input_files/large_file.txt", "input_files/large_file.txt", "input_files/large_file.txt"
                , "input_files/large_file.txt", "input_files/large_file.txt", "input_files/large_file.txt"
                , "input_files/large_file.txt", "input_files/large_file.txt", "input_files/large_file.txt"
                , "input_files/large_file.txt", "input_files/large_file.txt", "input_files/large_file.txt"
        );

        Assert.assertTrue(people.getPeople().size() == 97614 * 33);
    }
}
