package com.bridgelabz.basicproblems.countrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountRows {
    public static void main(String[] args) {
        String filePath = "D:\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\basicproblems\\countrows\\studentData.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            int count = 0;
            while((line = br.readLine()) != null){
                count++;
            }
            System.out.println("Number of rows in file excluding header row: " + (count-1));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
