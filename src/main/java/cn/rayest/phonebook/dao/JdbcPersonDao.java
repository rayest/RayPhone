package cn.rayest.phonebook.dao;

import cn.rayest.phonebook.domain.Person;
import cn.rayest.phonebook.util.ValidationUtil;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Rayest on 2016/6/19 0019.
 */
public class JdbcPersonDao extends JdbcDaoSupport implements PersonDao {

    public void addPerson(Person person) throws Exception {
        String sql = "INSERT persons(id, name, phoneNumber) VALUES (?, ?, ?)";

        boolean validationPhone = ValidationUtil.phoneNumberIsValid(person.getPhoneNumber());

        if (validationPhone == true) {
            getJdbcTemplate().update(sql, person.getId(), person.getName(), person.getPhoneNumber());
        }
    }


    public List loadPersons() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM persons";
        return getJdbcTemplate().query(sql, new PersonMapper());
    }

    private class PersonMapper implements RowMapper {
        public Object mapRow(ResultSet resultSet, int rowNnm) throws SQLException {
            Person person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setPhoneNumber(resultSet.getString("phoneNumber"));
            return person;
        }
    }


    public Person findPersonByName(String name) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM persons WHERE name = ?";
        return getJdbcTemplate().queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(Person.class), name);
    }

    public void updatePerson(int id, Person person) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE persons SET name = ?, phoneNumber = ? WHERE id = ?";

        boolean validationPhone = ValidationUtil.phoneNumberIsValid(person.getPhoneNumber());


        if (validationPhone == true) {
            getJdbcTemplate().update(sql, id, person.getName(), person.getPhoneNumber());
        }
     }

    public void deletePerson(int id) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM persons WHERE id = ?";
        getJdbcTemplate().update(sql, id);
    }
}
