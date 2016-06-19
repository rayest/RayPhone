package cn.rayest.phonebook.dao;

import cn.rayest.phonebook.model.Person;
import cn.rayest.phonebook.util.ValidationUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static cn.rayest.phonebook.util.ValidationUtil.phoneNumberIsValid;

/**
 * Created by Rayest on 2016/6/19 0019.
 */
public class PersonDaoImpl implements PersonDao{

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addPerson(Person person) throws Exception {
        String sql = "INSERT persons(name,phoneNumber) VALUES (?, ?)";

        boolean validationPhone = ValidationUtil.phoneNumberIsValid(person.getPhoneNumber());

        if (validationPhone == true){
            jdbcTemplate.update(sql, new Object[]{
                person.getName(), person.getPhoneNumber()
            });
        }
    }


    public List loadPersons() throws SQLException, ClassNotFoundException {
        String sql = "select * from persons";
        return jdbcTemplate.query(sql, new PersonMapper());
    }
    private class PersonMapper implements RowMapper{
        public Object mapRow(ResultSet resultSet, int rowNnm) throws SQLException {
            Person person = new Person();
            person.setName(resultSet.getString("name"));
            person.setPhoneNumber(resultSet.getString("phoneNumber"));
            return person;
        }
    }


    public Person findPersonByName(String name) throws ClassNotFoundException, SQLException {
        String sql = "select * from person where name = ?";
        return jdbcTemplate.queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(Person.class), name);
    }

    public Person editPerson(String name, Person person) throws ClassNotFoundException, SQLException {
        String sql = "update persons set name = ?, phoneNumber = ? where name = ?";
        jdbcTemplate.update(sql, person.getName(), person.getPhoneNumber());
        return person;
    }

    public void deletePerson(String name) throws ClassNotFoundException, SQLException {
         String sql = "delete from person where name = ?";
        jdbcTemplate.update(sql, name);
    }
}
