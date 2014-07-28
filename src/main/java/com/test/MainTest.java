package com.test;


import com.test.model.People;
import com.test.parser.ParserFactory;
import com.test.view.SimpleView;
import com.test.view.View;
import com.test.model.People;
import com.test.view.SimpleView;
import com.test.view.View;

public class MainTest {

    private static final View VIEW = new SimpleView();

    public static void main(String[] args) {
        People people = ParserFactory.parse("input_files/comma.txt", "input_files/pipe.txt", "input_files/space.txt");

        String out =
                "Output 1:\n" + VIEW.print(people.getSortedByGenderDescendingThenLastName())
                + "\nOutput 2:\n" + VIEW.print(people.getPeopleSortedByBirthAscending())
                + "\nOutput 3:\n" + VIEW.print(people.getPeopleSortedByLastNameDescending());

        System.out.println(out);
    }
}
