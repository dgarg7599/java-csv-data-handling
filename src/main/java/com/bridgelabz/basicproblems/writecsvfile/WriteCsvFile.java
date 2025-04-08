package com.bridgelabz.basicproblems.writecsvfile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCsvFile {
    public static void main(String[] args) {
        String filePath = "D:\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\basicproblems\\writecsvfile\\employeeDetails.csv";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            writer.write("ID,Name,Department,Salary\n");
            writer.write("104,John,Finance,62000\n");
            writer.write("105,Elia,HR,58000\n");
            writer.write("106,Aman,Marketing,33000\n");
            writer.write("107,Ayush,Accounts,40000\n");
            writer.write("105,Hemant,HR,58000\n");
            writer.close();

            System.out.println("CSV File written successfully.");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
