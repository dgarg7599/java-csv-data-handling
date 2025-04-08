package com.bridgelabz.intermediateproblems.searchforarecord;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class SearchEmployee {
    public static void main(String[] args) {
        String filePath = "D:\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\intermediateproblems\\searchforarecord\\employeeDetails.csv";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the employee name to search: ");
        String searchName = sc.nextLine().trim();
        boolean found = false;

        try(CSVReader reader = new CSVReader(new FileReader(filePath))){
            List<String[]> allRows = reader.readAll();

            for(int i=1;i<allRows.size();i++){
                String[] row = allRows.get(i);
                String name = row[1].trim();

                if(name.equalsIgnoreCase(searchName)){
                    String department = row[2].trim();
                    String salary = row[3].trim();
                    System.out.println("Name: " + name + ", Department: " + department + ", Salary: " + salary);
                    found = true;
                    break;
                }
            }

            if(!found){
                System.out.println("No records found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
