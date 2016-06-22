package cn.rayest.phonebook.controller;

import cn.rayest.phonebook.dao.JdbcPersonDao;
import cn.rayest.phonebook.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rayest on 2016/6/19 0019.
 */

@Controller
public class AddController {

    private JdbcPersonDao jdbcPersonDao;

    public JdbcPersonDao getJdbcPersonDao() {
        return jdbcPersonDao;
    }

    public void setJdbcPersonDao(JdbcPersonDao jdbcPersonDao) {
        this.jdbcPersonDao = jdbcPersonDao;
    }

    @RequestMapping("add")
    public String add(HttpServletRequest request, HttpServletResponse response){
        return "add";
    }

    @RequestMapping("added")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String name = request.getParameter("name");
        String phoneNumber = request.getParameter("phoneNumber");
        Map model = new HashMap();

        Person person = new Person();
        person.setName(name);
        person.setPhoneNumber(phoneNumber);
        jdbcPersonDao.addPerson(person);
        return new ModelAndView("added", model);
    }
}