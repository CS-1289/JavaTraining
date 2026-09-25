package com.training.ioapp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteFileWrite {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\10097443\\dover_data\\notes.txt");

        File folder = file.getParentFile();
        if (!folder.exists()) {
            folder.mkdirs();
        }

        FileOutputStream fos = new FileOutputStream(file, true);

        String data = "\nWelcome to Dover!";
        byte[] bytes = data.getBytes();

        fos.write(bytes);
        fos.close();

        System.out.println("Content appended successfully.");
    }
}