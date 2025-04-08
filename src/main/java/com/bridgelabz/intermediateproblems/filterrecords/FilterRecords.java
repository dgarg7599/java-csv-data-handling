package com.bridgelabz.intermediateproblems.filterrecords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecords {
    public static void main(String[] args) {
        String filePath = "D:\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\intermediateproblems\\filterrecords\\studentData.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;

            br.readLine(); // skip header

            while((line = br.readLine()) != null){
                String[] fields = line.split(",");
                double marks = Double.parseDouble(fields[3]);
                if(marks>80){
                    System.out.println(line);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
