package com.bridgelabz.advanceproblems.validatecsvdata;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.regex.Pattern;

public class CSVvalidator {
    public static void main(String[] args) {
        String filePath = "D:\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\advanceproblems\\validatecsvdata\\employees.csv";

        // regex pattern
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Pattern phonePattern = Pattern.compile("^[0-9]{10}$");

        try(CSVReader reader = new CSVReader(new FileReader(filePath))){

            int lineNum = 0;
            String[] row;

            while ((row = reader.readNext()) != null) {
                lineNum++;
                // Skip header
                if (lineNum == 1) continue;

                String name = row[0].trim();
                String email = row[1].trim();
                String phone = row[2].trim();

                boolean valid = true;

                if(!emailPattern.matcher(email).matches()){
                    System.out.println("Invalid email address for " + name + ": " + email);
                    valid = false;
                }

                if(!phonePattern.matcher(phone).matches()){
                    System.out.println("Invalid phone number for " + name + ": " + phone);
                    valid = false;
                }

                if(!valid){
                    System.out.println("Invalid row: " + String.join(", ", row));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
