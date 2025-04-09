package com.bridgelabz.advanceproblems.readlargecsvfile;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadLargeCSVInChunks {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/bridgelabz/advanceproblems/readlargecsvfile/largeData.csv";
        int batchSize = 100;
        int totalProcessed = 0;

        try(CSVReader reader = new CSVReader(new FileReader(filePath))){
            String[] line;
            List<String[]> chunks = new ArrayList<>();

            //skip header
            reader.readNext();

            while((line = reader.readNext()) != null){
                chunks.add(line);

                if(chunks.size() == batchSize){
                    // process the current chunk
                    processChunk(chunks);
                    totalProcessed += chunks.size();
                    chunks.clear();
                }
            }

            // process remaining lines
            if(!chunks.isEmpty()){
                processChunk(chunks);
                totalProcessed += chunks.size();
            }
            System.out.println("Total records processed: " + totalProcessed);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void processChunk(List<String[]> chunks) {
        // Dummy processing: just print how many lines in this chunk
        System.out.println("Processing chunk: " + chunks.size());
    }
}
