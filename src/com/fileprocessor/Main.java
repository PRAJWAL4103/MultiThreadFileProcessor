package com.fileprocessor;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        File folder = new File("input");
        File[] files = folder.listFiles();

        ResultManager manager = new ResultManager();

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        if (files != null) {
            for (File file : files) {

                if (file.isFile()) {
                    executor.execute(
                            new FileProcessor(file, manager)
                    );
                }
            }
        }

        executor.shutdown();
        System.out.println("All tasks submitted...");
    }
}