// File: FileReadWrite.java
import java.io.*;
import java.util.Scanner;

public class FileReadWrite {
    
    // Function to write content to a file
    public static void writeToFile(String filename, String content) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(content);
            writer.close();
            System.out.println("Successfully wrote to the file: " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file.");
            e.printStackTrace();
        }
    }
    
    // Function to read content from a file
    public static void readFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner reader = new Scanner(file);
            System.out.println("Content of " + filename + ":");
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }
    
    // Function to check if file exists
    public static boolean fileExists(String filename) {
        File file = new File(filename);
        return file.exists();
    }
    
    public static void main(String[] args) {
        String filename = "sample.txt";
        String content = "Hello, World!\nThis is a sample file.\nJava File Operations!";
        
        // Write to file
        writeToFile(filename, content);
        
        // Check if file exists
        if (fileExists(filename)) {
            System.out.println("File exists: true");
        }
        
        // Read from file
        readFromFile(filename);
    }
}