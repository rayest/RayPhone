package cn.rayest.phonebook.dao;

import cn.rayest.phonebook.domain.Person;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Rayest on 2016/6/19 0019.
 */
public interface PersonDao {
    void addPerson(Person person) throws Exception;
    List loadPersons() throws SQLException, ClassNotFoundException;
    Person findPersonByName(String name) throws ClassNotFoundException, SQLException;
    void updatePerson(int id, Person person) throws ClassNotFoundException, SQLException;
    void deletePerson(int id) throws ClassNotFoundException, SQLException;
}
