package com.sabel.sqlite;

import java.sql.SQLException;

public class TestPersonService {
    public static void main(String[] args) {
        //
//        Person person = new Person("Maier", 1976);
//        Person person1 = new Person("Mustermann", 1980);

        Person person = null;

        PersonService personService = null;
        try {
            personService = new PersonService();
            person = personService.readPerson(2);
//            personService.save(person1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                personService.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (person != null) {
            System.out.println(person.toString());
        }


    }
}
