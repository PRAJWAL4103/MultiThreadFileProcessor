package com.fileprocessor;

import java.io.*;

public class FileProcessor implements Runnable {

    private File file;
    private ResultManager manager;

    public FileProcessor(File file, ResultManager manager) {
        this.file = file;
        this.manager = manager;
    }

    @Override
    public void run() {

        int lines = 0;
        int words = 0;
        int characters = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null) {
                lines++;
                characters += line.length();
                words += line.split("\\s+").length;
            }

            String result = "Thread: " +
                    Thread.currentThread().getName()
                    + " | File: " + file.getName()
                    + " | Lines: " + lines
                    + " | Words: " + words
                    + " | Characters: " + characters;

            manager.writeResult(result);

            System.out.println("Processed: " + file.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
