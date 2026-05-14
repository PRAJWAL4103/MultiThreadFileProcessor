package com.fileprocessor;

import java.io.FileWriter;
import java.io.IOException;

public class ResultManager {

    public synchronized void writeResult(String result) {
        try {
            FileWriter writer = new FileWriter("output/result.txt", true);
            writer.write(result + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}