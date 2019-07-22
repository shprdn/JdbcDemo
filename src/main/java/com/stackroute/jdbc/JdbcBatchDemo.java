package com.stackroute.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class JdbcBatchDemo {


    public void getBatchDetails() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
            //setting up the driver connection
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");
             //Using PreparedStatement to execute queries
             PreparedStatement ps = connection.prepareStatement("insert into employee values(?,?,?,?)"))
        {
            //BufferedReader to get input from user
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            while(true){
               //entering records in the database
                System.out.println("enter id");
                String id=br.readLine();

                System.out.println("enter name");
                String name=br.readLine();

                System.out.println("enter age");
                String s3=br.readLine();
                int age=Integer.parseInt(s3);

                System.out.println("enter gender");
                String gender=br.readLine();

                ps.setString(1,id);
                ps.setString(2,name);
                ps.setInt(3,age);
                ps.setString(4,gender);

                ps.addBatch();
                //in case user wants to add more records
                System.out.println("Want to add more records y/n");
                String ans=br.readLine();
                if(ans.equals("n")){
                    break;
                }

            }
            ps.executeBatch();

            System.out.println("record successfully saved");
        }
        //catching up exception if found
        catch (Exception e)
        {
            e.getStackTrace();
        }
    }
}