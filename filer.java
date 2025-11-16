// File: FileCopier.java
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileCopier {
    
    // Function to copy file using FileInputStream and FileOutputStream
    public static void copyFile(String sourcePath, String destPath) {
        try {
            FileInputStream input = new FileInputStream(sourcePath);
            FileOutputStream output = new FileOutputStream(destPath);
            
            byte[] buffer = new byte[1024];
            int length;
            
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            
            input.close();
            output.close();
            System.out.println("File copied successfully from " + sourcePath + " to " + destPath);
            
        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
    }
    
    // Function to get file information
    public static void getFileInfo(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            System.out.println("File Name: " + file.getName());
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("File Size: " + file.length() + " bytes");
            System.out.println("Readable: " + file.canRead());
            System.out.println("Writable: " + file.canWrite());
            System.out.println("Executable: " + file.canExecute());
        } else {
            System.out.println("File does not exist: " + filename);
        }
    }
    
    // Function to delete a file
    public static boolean deleteFile(String filename) {
        File file = new File(filename);
        if (file.delete()) {
            System.out.println("Deleted the file: " + filename);
            return true;
        } else {
            System.out.println("Failed to delete the file: " + filename);
            return false;
        }
    }
    
    public static void main(String[] args) {
        String sourceFile = "sample.txt";
        String destFile = "sample_copy.txt";
        
        // Get file information
        getFileInfo(sourceFile);
        
        // Copy file
        copyFile(sourceFile, destFile);
        
        // Get information about copied file
        getFileInfo(destFile);
        
        // Delete the copied file (optional)
        // deleteFile(destFile);
    }
}