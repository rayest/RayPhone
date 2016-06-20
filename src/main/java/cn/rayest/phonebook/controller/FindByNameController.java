package cn.rayest.phonebook.controller;

import cn.rayest.phonebook.dao.JdbcPersonDao;
import cn.rayest.phonebook.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rayest on 2016/6/20 0020.
 */

@Controller
public class FindByNameController {
    private JdbcPersonDao jdbcPersonDao;

    public JdbcPersonDao getPersonDaoImpl() {
        return jdbcPersonDao;
    }

    public void setPersonDaoImpl(JdbcPersonDao jdbcPersonDao) {
        this.jdbcPersonDao = jdbcPersonDao;
    }

    @RequestMapping("find")
    public String find(HttpServletRequest request, HttpServletResponse response) {
        return "find";
    }

    @RequestMapping("found")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {

        Map model = new HashMap();
        String name = request.getParameter("name");
        Person person = jdbcPersonDao.findPersonByName(name);
        model.put("person", person);
        return new ModelAndView("found", model);

    }

    public void setJdbcPersonDao(JdbcPersonDao JdbcPersonDao) {
        jdbcPersonDao = JdbcPersonDao;
    }

    public JdbcPersonDao getJdbcPersonDao() {
        return jdbcPersonDao;
    }
}
