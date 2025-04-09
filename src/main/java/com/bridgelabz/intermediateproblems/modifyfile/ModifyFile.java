package com.bridgelabz.intermediateproblems.modifyfile;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class ModifyFile {
    public static void main(String[] args) {
        String inputFile = "D:\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\intermediateproblems\\modifyfile\\employeeDetails.csv";
        String outputFile = "D:\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\intermediateproblems\\modifyfile\\updatedEmployeeDetails.csv";

        try (
                CSVReader reader = new CSVReader(new FileReader(inputFile));
                CSVWriter writer = new CSVWriter(new FileWriter(outputFile));
        ){

            List<String[]> allRows = reader.readAll();

            // write header first
            writer.writeNext(allRows.get(0));

            for(int i=1;i<allRows.size();i++){
                String[] row = allRows.get(i);
                String department = row[2].trim();

                if(department.equalsIgnoreCase("IT")){
                    double salary = Double.parseDouble(row[3].trim());
                    salary = salary * 1.10;
                    row[3] = String.valueOf(salary);
                }

                writer.writeNext(row);
            }

            System.out.println("Updated file.");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
