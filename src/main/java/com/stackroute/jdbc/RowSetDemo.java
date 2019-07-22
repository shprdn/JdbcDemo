package com.stackroute.jdbc;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetDemo {

    public void getRowSetDetails(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        //setting up the connection using jdbc
        //setting username and password
        try(JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet())
        {
            rowSet.setUrl("jdbc:mysql://localhost:3306/employeedb");
            rowSet.setUsername("root");
            rowSet.setPassword("Root@123");
            System.out.println(rowSet.getUrl());
            //command to fetch record based on the query
            rowSet.setCommand("select * from employee");


            rowSet.execute();
            //fetching rows using next()
            while (rowSet.next()) {
                // Generating cursor Moved event
                System.out.println("Id: " + rowSet.getInt(1) + " Name: " + rowSet.getString(2)
                        + " Age: " + rowSet.getInt(3) + " Gender: " + rowSet.getString(4));
            }

        }
        //catching exception if found
        catch (Exception e)
        {
            e.getStackTrace();
        }
    }
}
