package com.bridgelabz.intermediateproblems.filterrecords;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FilterRecords {
    public static void main(String[] args) {
        String filePath = "D:\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\intermediateproblems\\filterrecords\\studentData.csv";

//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
//            String line;
//
//            br.readLine(); // skip header
//
//            while((line = br.readLine()) != null){
//                String[] fields = line.split(",");
//                double marks = Double.parseDouble(fields[3]);
//                if(marks>80){
//                    System.out.println(line);
//                }
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }

        try(CSVReader reader = new CSVReader(new FileReader(filePath))){

            List<String[]> allRows = reader.readAll(); // read all rows at once
            // start from index 1 to skip header
            for(int i=1;i<allRows.size();i++){
                String[] row = allRows.get(i);
                double marks = Double.parseDouble(row[3]);

                if(marks>80){
                    System.out.println(String.join(", ",row));
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
