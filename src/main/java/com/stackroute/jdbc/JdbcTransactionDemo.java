package com.stackroute.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcTransactionDemo {
    public void getDetails() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

       //setting up database connection using driver
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");
                PreparedStatement ps = connection.prepareStatement("insert into employee values(?,?,?,?)");) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //setting auto commit to false
            connection.setAutoCommit(false);

            while (true) {
                //details to be entered by the user
                //ID
                System.out.println("enter id");
                String id = br.readLine();

                //Name
                System.out.println("enter name");
                String name = br.readLine();

                //Age
                System.out.println("enter age");
                String s3 = br.readLine();
                int age = Integer.parseInt(s3);

                //Gender
                System.out.println("enter gender");
                String gender = br.readLine();

                //setting up the records using setters
                ps.setString(1, id);
                ps.setString(2, name);
                ps.setInt(3, age);
                ps.setString(4, gender);

                ps.executeUpdate();
                //asking permission to either commit or rollback
                System.out.println("commit/rollback");
                String answer = br.readLine();
                if (answer.equals("commit")) {
                    connection.commit();
                }
                if (answer.equals("rollback")) {
                    connection.rollback();
                }
                //in case user wants to enter more records
                System.out.println("want to add more records y/n");
                String ans = br.readLine();
                if (ans.equals("n")) {
                    break;
                }
            }
                connection.commit();
                System.out.println("record successfully saved");
        //catch if any exception found
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
