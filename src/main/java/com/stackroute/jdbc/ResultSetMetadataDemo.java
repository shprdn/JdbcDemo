package com.stackroute.jdbc;

import java.sql.*;

public class ResultSetMetadataDemo
{
    public void resultSetDbMetadata()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");)
        {
            ResultSetMetaData resultSetMetadataDemo = resultSet.getMetaData();
            System.out.println();
            System.out.println("---------------Database ResultSetMetaData------------------");
            System.out.println();
            System.out.println("Total columns: "+resultSetMetadataDemo.getColumnCount());
            System.out.println("Column Name of 1st column: "+resultSetMetadataDemo.getColumnName(1));
            System.out.println("Column Type Name of 1st column: "+resultSetMetadataDemo.getColumnTypeName(1));
        }
        catch (Exception e)
        {
            e.getStackTrace();
        }

    }
}
