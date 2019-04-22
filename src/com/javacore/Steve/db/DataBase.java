package com.javacore.Steve.db;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataBase {

    private Object tableLook = new Object();

    Map<String, Table> tables;

    public List<Record> select() {
        // While tableLook has any other object, others won't be able to execute this code block.
        synchronized (tableLook) {
            System.out.println("Starting selecting records...");
            try {
                Thread.sleep(500);
                System.out.println("Finished selecting!");
            } catch (InterruptedException e) {

            }
        }

        return null;
    }

    public void update() {
        // While one thread won't stop working with object others can't.
        System.out.println("Starting updating database...");
        synchronized (tableLook) {
            try {
                Thread.sleep(10000);
                System.out.println("Finished updating database!");
            } catch (InterruptedException e) {

            }
        }
    }

    public static List<String[]> readDataFile(String fileName) {
        FileInputStream fileInputStream = null;
        List<String[]> result = new ArrayList<>();
        BufferedReader bufferedReader;
        try {
            fileInputStream = new FileInputStream(fileName);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Source line: " + line);
                if (line.indexOf("#") == -1){
                    result.add(line.split(";"));
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException iOException) {
            iOException.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException nPE) {
                nPE.printStackTrace();
            }
        }
        return result;
    }

    public void delete() {
        System.out.println("Deleting...");
    }

    public void insert(Record record, Table table) {

    }
}
