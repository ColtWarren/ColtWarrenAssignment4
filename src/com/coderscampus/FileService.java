package com.coderscampus;

import java.io.*;

public class FileService {

    public String[] read(String filePath) {
        int LineCount = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            bufferedReader.readLine();
            while (bufferedReader.readLine() != null) LineCount++;
        } catch (IOException e) {
            System.out.println("There was an error counting lines in " + filePath + " : " + e.getMessage());
        }

        String[] Lines = new String[LineCount];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
              bufferedReader.readLine();
            for (int i = 0; i < LineCount; i++) {
                Lines[i] = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("There was an error reading lines in " + filePath + " : " + e.getMessage());
        }
        return Lines;
    }

    public void write(String filePath, String[] lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


