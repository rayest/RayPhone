package cn.rayest.phonebook.controller;

import cn.rayest.phonebook.dao.JdbcPersonDao;
import cn.rayest.phonebook.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Rayest on 2016/6/19 0019.
 */

@Controller
public class UpdateController {

    private JdbcPersonDao jdbcPersonDao;

    public JdbcPersonDao getJdbcPersonDao() {
        return jdbcPersonDao;
    }

    public void setJdbcPersonDao(JdbcPersonDao jdbcPersonDao) {
        this.jdbcPersonDao = jdbcPersonDao;
    }

    @RequestMapping("update")
    public String update(HttpServletRequest request, HttpServletResponse response) {
        return "update";
    }


    @RequestMapping("updated")
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {


        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String phoneNumber = request.getParameter("phoneNumber");


        Person person = new Person();

        person.setId(id);
        person.setName(name);
        person.setPhoneNumber(phoneNumber);

        jdbcPersonDao.updatePerson(id, person);

        return "updated";
    }


}
