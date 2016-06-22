package cn.rayest.phonebook.controller;

import cn.rayest.phonebook.dao.JdbcPersonDao;
import cn.rayest.phonebook.domain.Person;
import cn.rayest.phonebook.util.JSONResult;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Rayest on 2016/6/22 0022.
 */

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    JdbcPersonDao jdbcPersonDao;

    @ResponseBody
    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/json")
    public Object getPerson(@PathVariable String name) throws SQLException, ClassNotFoundException {
        Person person = jdbcPersonDao.findPersonByName(name);
        return JSONResult.response(name, person);
    }

    @ResponseBody
    @RequestMapping(value = "/persons", method = RequestMethod.GET, produces = "application/json")
    public Object getListPersons() throws SQLException, ClassNotFoundException {
        List<Map<String, Object>> personsList = jdbcPersonDao.loadPersons();
        return JSONResult.response("persons", personsList);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Object deletePerson(@PathVariable int id) throws Exception {
        jdbcPersonDao.deletePerson(id);
        return JSONResult.success();
    }

    @ResponseBody
    @RequestMapping(value = "/person/{id}", method = RequestMethod.PUT)
    public void updatePerson(@PathVariable int id, Person person) throws Exception {
        jdbcPersonDao.updatePerson(id, person);
    }

    @ResponseBody
    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public void addPerson(Person person) throws Exception {
        jdbcPersonDao.addPerson(person);
    }



}
