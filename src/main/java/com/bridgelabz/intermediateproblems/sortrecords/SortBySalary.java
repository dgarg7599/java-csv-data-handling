package com.bridgelabz.intermediateproblems.sortrecords;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.List;

public class SortBySalary {
    public static void main(String[] args) {
        String filePath = "D:\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\intermediateproblems\\sortrecords\\employees.csv";

        try(CSVReader reader = new CSVReader(new FileReader(filePath))){

            List<String[]> allRows = reader.readAll();
            // remove and store header
            String[] header = allRows.remove(0);
            //sort rows by descending order
            allRows.sort((a, b) -> {
                double salaryA = Double.parseDouble(a[3].trim());
                double salaryB = Double.parseDouble(b[3].trim());
                return Double.compare(salaryB, salaryA); //descending
            });

            System.out.println(String.join(",", header));

            for(int i = 0; i < Math.min(5, allRows.size()); i++){
                System.out.println(String.join(",", allRows.get(i)));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
