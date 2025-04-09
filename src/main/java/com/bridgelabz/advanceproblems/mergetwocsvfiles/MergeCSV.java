import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) {
        String students1Path = "src/main/java/com/bridgelabz/advanceproblems/mergetwocsvfiles/students1.csv";
        String students2Path = "src/main/java/com/bridgelabz/advanceproblems/mergetwocsvfiles/students2.csv";
        String mergedFilePath = "src/main/java/com/bridgelabz/advanceproblems/mergetwocsvfiles/mergedStudents.csv";

        try (
                CSVReader reader1 = new CSVReader(new FileReader(students1Path));
                CSVReader reader2 = new CSVReader(new FileReader(students2Path));
                CSVWriter writer = new CSVWriter(new FileWriter(mergedFilePath))
        ) {
            // Read all rows at once
            List<String[]> rows1 = reader1.readAll();
            List<String[]> rows2 = reader2.readAll();

            // Prepare a map from students1
            Map<String, String[]> studentMap = new HashMap<>();

            // Skip header: start from i=1
            for (int i = 1; i < rows1.size(); i++) {
                String[] row = rows1.get(i);
                String id = row[0].trim();
                studentMap.put(id, row);
            }

            // Write header
            writer.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"});

            // Loop through second file rows (excluding header)
            for (int i = 1; i < rows2.size(); i++) {
                String[] row = rows2.get(i);
                String id = row[0].trim();
                String[] details1 = studentMap.get(id);

                if (details1 != null) {
                    String[] merged = new String[]{
                            id,
                            details1[1].trim(), // Name
                            details1[2].trim(), // Age
                            row[1].trim(),      // Marks
                            row[2].trim()       // Grade
                    };
                    writer.writeNext(merged);
                }
            }

            System.out.println("Merging completed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
