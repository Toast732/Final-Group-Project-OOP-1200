package javaProject.methods;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIOManager {
    private final String filePath;

    public FileIOManager(String filePath) {
        this.filePath = filePath;
    }

    public List<String> readFile() {
        List<String> lines = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File does not exist: " + filePath);
            return lines;
        }

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

    public void appendToFile(String content) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            boolean created = file.createNewFile();
            if (!created) {
                throw new IOException("Failed to create file: " + filePath);
            }
        }

        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(content);
        } catch (IOException e) {
            throw new IOException("Failed to write to file: " + filePath, e);
        }
    }
}
