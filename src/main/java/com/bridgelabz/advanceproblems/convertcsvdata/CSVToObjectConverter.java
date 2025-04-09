package com.bridgelabz.advanceproblems.convertcsvdata;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVToObjectConverter {
    public static void main(String[] args) {
        String filePath = "D:\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\advanceproblems\\convertcsvdata\\studentData.csv";
        List<Student> students = new ArrayList<>();

        try(CSVReader csvReader = new CSVReader(new FileReader(filePath))){
            String[] line;
            int rowNum = 0;

            while((line = csvReader.readNext()) != null){
                if(rowNum++ == 0)continue;

                int id = Integer.parseInt(line[0].trim());
                String name = line[1].trim();
                int age = Integer.parseInt(line[2].trim());
                double marks = Double.parseDouble(line[3].trim());

                Student student = new Student(id, name, age, marks);
                students.add(student);
            }

            for(Student student : students){
                System.out.println(student);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
