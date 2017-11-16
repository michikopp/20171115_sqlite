package com.sabel.sqlite;

import java.sql.*;

public class PersonService {

    private static final String URL = "jdbc:sqlite:d:\\Personen.sqlite";

    private Connection connection;
    private Statement statement;

    public PersonService() throws SQLException {
        this.connection = DriverManager.getConnection(URL);
        this.statement = connection.createStatement();
    }

    public void close() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        statement = null;

        if (connection != null) {
            connection.close();
        }
        connection = null;
    }

    public void save(Person person) throws SQLException {
        String sql = "INSERT INTO person VALUES(" + person.getId() + ", '" + person.getNachname() + "', " + person.getJahrgang() + ")";
        this.statement.executeUpdate(sql);
    }

    public Person readPerson(int id) throws SQLException {
        String sql = "SELECT id, nachname, jahrgang FROM person WHERE id = " + String.valueOf(id);
        ResultSet resultSet = this.statement.executeQuery(sql);

        Person person = null;

        if (resultSet.next()) {
            int personId = resultSet.getInt(1);
            String nachname = resultSet.getString(2);
            int jahrgang = resultSet.getInt(3);
            person = new Person(personId, nachname, jahrgang);
        }

        return person;
    }
}
