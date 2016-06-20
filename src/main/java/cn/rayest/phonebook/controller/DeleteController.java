package cn.rayest.phonebook.controller;

import cn.rayest.phonebook.dao.JdbcPersonDao;
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
public class DeleteController {
    private JdbcPersonDao jdbcPersonDao;

    public JdbcPersonDao getJdbcPersonDao() {
        return jdbcPersonDao;
    }

    public void setJdbcPersonDao(JdbcPersonDao jdbcPersonDao) {
        this.jdbcPersonDao = jdbcPersonDao;
    }

    @RequestMapping("delete")
    public String delete(HttpServletRequest request, HttpServletResponse response) {
        return "delete";
    }

    @RequestMapping("deleted")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
        Map model = new HashMap();
        int id = Integer.parseInt(request.getParameter("id"));

        jdbcPersonDao.deletePerson(id);
        return new ModelAndView("deleted", model);
    }
}
