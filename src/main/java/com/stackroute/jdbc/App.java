package com.stackroute.jdbc;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //creating object of simpleJdbcDemo class
        SimpleJdbcDemo simpleJdbcDemo = new SimpleJdbcDemo();


        //method to get all employees details
        simpleJdbcDemo.getEmployeeDetails();


        //method to get all employees in reverse order
        simpleJdbcDemo.getEmployeeDetailsInReverse();


        //method to get employees details in reverse order till second row
        simpleJdbcDemo.getEmployeeDetailsFromSecondRowInReverse();


        //fetching employee details using name and gender
        simpleJdbcDemo.getEmployeeDetailsByNameAndGender("SRK","male");


        //displaying metadata details of the database
        DatabaseMetadataDemo databaseMetadataDemo = new DatabaseMetadataDemo();
        databaseMetadataDemo.DbMetadata();

        //displaying metadata details of our resultset
        ResultSetMetadataDemo resultSetMetadataDemo = new ResultSetMetadataDemo();
        resultSetMetadataDemo.resultSetDbMetadata();

        //fetching batchdetails of our database
        JdbcBatchDemo jdbcBatchDemo = new JdbcBatchDemo();
        jdbcBatchDemo.getBatchDetails();

        //transaction details
        JdbcTransactionDemo jdbcTransactionDemo = new JdbcTransactionDemo();
        jdbcTransactionDemo.getDetails();

        //fetching details using rowSet
        RowSetDemo rowSetDemo = new RowSetDemo();
        rowSetDemo.getRowSetDetails();
    }
}
