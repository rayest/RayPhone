package cn.rayest.phonebook.util;

import cn.rayest.phonebook.domain.Person;
import com.alibaba.fastjson.JSONObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rayest on 2016/6/21 0021.
 */
public class DBUtil {

        private static Connection getConnection() {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=true";
            String user = "root";
            String password = "199011081108";
            Connection connection = null;

            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }catch (SQLException e){
                e.printStackTrace();
            }
            return connection;
        }


        public static int insert(JSONObject person) throws Exception {
            Connection connection = getConnection();
            int i = 0;

            String sql = "insert into persons(id, name, phoneNumber) values (15, 'lapa', '15715185099')";

            //String sql = "insert into persons(id,name,phonenumber)values('"+person.getId()+"','"+person.getName()+"','"+person.getPhoneNumber()+"')";
            PreparedStatement preparedStatement;

            preparedStatement = connection.prepareStatement(sql);
            i = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            return i;
        }

        public static int delete(int id) throws SQLException {
            Connection connection = getConnection();
            int i = 0;
            String sql = "delete from persons where id = '" + id + "'";
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(sql);
            i = preparedStatement.executeUpdate();
            System.out.println("result: " + i);
            preparedStatement.close();
            connection.close();
            return i;
        }


        public static int update(int id, Person person) throws SQLException {
            Connection connection = getConnection();
            int i = 0;
            PreparedStatement preparedStatement;
            String sql = " update persons set name = '" + person.getName() + "', phoneNumber = '" + person.getPhoneNumber() + "' where id = '" + id + "'";
            preparedStatement = connection.prepareStatement(sql);
            i = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            return i;
        }

        public static List<Person> selectAll() throws SQLException {
            Connection connection = getConnection();
            String sql = "select * from persons";
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Person> persons = new ArrayList<Person>();
            while (resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt(1));
                person.setName(resultSet.getString(2));
                person.setPhoneNumber(resultSet.getString(3));
                persons.add(person);
            }
            return persons;
        }

        public static List<Person> selectById(int id) throws Exception {
            Connection connection = getConnection();
            PreparedStatement preparedStatement;
            String sql = "select * from persons where id = '" + id + "'";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Person> persons=new ArrayList<Person>();
            while (resultSet.next()){
                Person person=new Person();
                person.setId(resultSet.getInt(1));
                person.setName(resultSet.getString(2));
                person.setPhoneNumber(resultSet.getString(3));
                persons.add(person);}
            return persons;
        }



}
