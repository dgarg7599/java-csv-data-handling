package com.bridgelabz.advanceproblems.detectduplicates;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DetectDuplicates {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/bridgelabz/advanceproblems/detectduplicates/employees.csv";
        // set to track unique ids
        Set<String> uniqueIds = new HashSet<String>();
        // list to store duplicates
        List<String[]> duplicates = new ArrayList<>();

        try(CSVReader reader = new CSVReader(new FileReader(filePath))){
            String[] row;
            int lineCount = 0;

            while((row = reader.readNext()) != null){
                lineCount++;
                if(lineCount == 1) continue; //skip header

                String id = row[0].trim();

                if(!uniqueIds.add(id)){
                    duplicates.add(row);  //duplicate id found (if not added in hashset)
                }
            }

            if(duplicates.isEmpty()){
                System.out.println("No duplicates found");
            }else{
                System.out.println("Duplicates found ");
                for(String[] duplicate : duplicates){
                    System.out.println(String.join(", ", duplicate));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
