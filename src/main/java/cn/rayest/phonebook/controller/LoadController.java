package cn.rayest.phonebook.controller;

import cn.rayest.phonebook.dao.PersonDaoImpl;
import cn.rayest.phonebook.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rayest on 2016/6/19 0019.
 */

@Controller
public class LoadController {
    private PersonDaoImpl personDaoImpl;
    public PersonDaoImpl getPersonDaoImpl() {
        return personDaoImpl;
    }

    public void setPersonDaoImpl(PersonDaoImpl personDaoImpl) {
        this.personDaoImpl = personDaoImpl;
    }
    @RequestMapping("load")
    public String load1(HttpServletRequest request, HttpServletResponse response) {
        return "load";
    }

    @RequestMapping(value = "loaded")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Map model = new HashMap();
        List person = personDaoImpl.loadPersons();

        model.put("person", person);
        return new ModelAndView("loaded", model);
    }


}
