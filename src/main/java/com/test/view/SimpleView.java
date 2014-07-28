package com.test.view;

import com.test.model.Person;
import com.test.model.Person;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SimpleView implements View {
    /**
     * This method will print out all information about a person. It will have the following output:
     *
     *      LastName FirstName Gender BirthDate FavoriteColor
     *
     * @param records A list of person objects to iterate through and print their information.
     * @return If null or empty list then empty string otherwise a string with the format that was
     * explained above.
     */
    @Override
    public String print(List<Person> records) {
        if (records == null) return "";

        return records.stream().map(p ->
            p.getLastName() + " " + p.getFirstName()
            +  " " + p.getGender().getValue() + " " + getDate(p)
            + " " + p.getFavoriteColor() + "\n"
        ).reduce("", String::concat);
    }

    /**
     * This method will print multiple Person lists. Any null records will be filtered out.
     *
     * It will have the following output:
     *
     * Output 1:
     * (all persons information for first list)
     *
     * ...
     *
     * Output n:
     * (all persons information for nth list)
     *
     * @param record
     * @param records
     * @return A string output with the format explained above. The implementation should filter
     * out any null records. If only null records are supplied return an empty string.
     */
    @Override
    public String print(List<Person> record, List<Person>... records) {
        int i;
        String out = "";

        if (record != null && record.size() > 0) {
            i = 2;
            out = "Output 1:\n" + print(record);
        } else {
            i = 1;
        }

        for (List<Person> p : records) {
            if (p != null) {
                if (i != 1) {
                    out += "\n";
                }

                out += "Output " + i + ":\n" + print(p);
                i++;
            }
        }

        return out;
    }

    private String getDate(Person person) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
        return person.getDateOfBirth().format(dtf);
    }
}
