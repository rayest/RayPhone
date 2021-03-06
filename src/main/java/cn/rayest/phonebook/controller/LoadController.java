package cn.rayest.phonebook.controller;

import cn.rayest.phonebook.dao.JdbcPersonDao;
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
    private JdbcPersonDao jdbcPersonDao;

    public JdbcPersonDao getJdbcPersonDao() {
        return jdbcPersonDao;
    }

    public void setJdbcPersonDao(JdbcPersonDao jdbcPersonDao) {
        this.jdbcPersonDao = jdbcPersonDao;
    }

    @RequestMapping("load")
    public String load1(HttpServletRequest request, HttpServletResponse response) {
        return "load";
    }

    @RequestMapping(value = "loaded")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Map model = new HashMap();
        List person = jdbcPersonDao.loadPersons();

        model.put("person", person);
        return new ModelAndView("loaded", model);
    }


}
