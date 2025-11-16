// File: StudentDataManager.java
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDataManager {
    
    // Function to append data to file (add without overwriting)
    public static void appendToFile(String filename, String data) {
        try {
            FileWriter writer = new FileWriter(filename, true); // true for append mode
            writer.write(data + "\n");
            writer.close();
            System.out.println("Data appended to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }
    
    // Function to read all lines from file into a list
    public static List<String> readAllLines(String filename) {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        return lines;
    }
    
    // Function to create directory
    public static void createDirectory(String dirName) {
        File dir = new File(dirName);
        if (dir.mkdir()) {
            System.out.println("Directory created: " + dirName);
        } else {
            System.out.println("Failed to create directory or directory already exists: " + dirName);
        }
    }
    
    // Function to list files in directory
    public static void listFiles(String dirName) {
        File dir = new File(dirName);
        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Files in directory " + dirName + ":");
            String[] files = dir.list();
            if (files != null) {
                for (String file : files) {
                    System.out.println(" - " + file);
                }
            }
        } else {
            System.out.println("Directory does not exist: " + dirName);
        }
    }
    
    public static void main(String[] args) {
        String filename = "students.txt";
        String dataDir = "student_data";
        
        // Create directory
        createDirectory(dataDir);
        
        // Add student records
        appendToFile(filename, "John Doe,25,Computer Science");
        appendToFile(filename, "Jane Smith,22,Mathematics");
        appendToFile(filename, "Bob Johnson,24,Physics");
        
        // Read and display all student records
        List<String> students = readAllLines(filename);
        System.out.println("\nAll Student Records:");
        for (String student : students) {
            System.out.println(student);
        }
        
        // List files in current directory
        System.out.println("\nFiles in current directory:");
        listFiles(".");
    }
}