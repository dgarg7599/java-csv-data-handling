package com.bridgelabz.basicproblems.readcsvfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCsvFile {
    public static void main(String[] args) {
        String filePath = "D:\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\basicproblems\\readcsvfile\\studentData.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            boolean isFirstLine = true;
            while((line = br.readLine()) != null){

                if(isFirstLine){
                    isFirstLine = false;
                    continue;  // skip header
                }

                String[] fields = line.split(",");
                System.out.println("ID:" + fields[0] + ", Name:" + fields[1] + ", Age:" + fields[2] + ", Marks:" + fields[3]);
            }
        }catch(IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
