package javaProject.methods;

//Imports
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Handles fileIO read and write - uses append to write without overwrite
public class FileIOManager {
    private final String filePath;

    // Constructor that initializes the FileIOManager with a specific file path.
    public FileIOManager(String filePath) {
        this.filePath = filePath;
    }

    // Reads all lines from the file and returns them as a list of strings.
    public List<String> readFile() {
        List<String> lines = new ArrayList<>();
        File file = new File(filePath);

        // Check if the file exists before attempting to read
        if (!file.exists()) {
            System.out.println("File does not exist: " + filePath);
            return lines;
        }

        // BufferedReader to read text from a file
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return lines;
    }

    // Ensure the file exists and create it if it doesn't
    public void appendToFile(String content) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            boolean created = file.createNewFile();
            if (!created) {
                throw new IOException("Failed to create file: " + filePath);
            }
        }

        // Use FileWriter to write text to the file in append mode
        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(content);
        } catch (IOException e) {
            throw new IOException("Failed to write to file: " + filePath, e);
        }
    }
}
