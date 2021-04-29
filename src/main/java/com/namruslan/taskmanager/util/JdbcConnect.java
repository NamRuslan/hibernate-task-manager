package com.namruslan.taskmanager.util;

import com.namruslan.taskmanager.entity.TaskClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JdbcConnect {
    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        getAll();
    }

    private static void getAll() {
        String query = "select * from tasks_table";

        List<TaskClass> list = new ArrayList<>();

        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                TaskClass task = new TaskClass();
                task.setId(resultSet.getInt("id"));
                task.setTaskName(resultSet.getString("task_name"));
                task.setOwner(resultSet.getString("owner"));
                task.setPriority(resultSet.getInt("priority"));
                list.add(task);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        for(TaskClass task : list) {
            System.out.println(task.getId() + " - " + task.getTaskName() + " - " + task.getOwner());
        }
    }

    private static Connection getConnection() throws IOException, SQLException {
        Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(inputStream);
        }
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }

}
