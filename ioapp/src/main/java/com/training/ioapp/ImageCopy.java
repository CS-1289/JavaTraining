package com.training.ioapp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ImageCopy {

    public static void main(String[] args) throws IOException {
        File folder = new File("C:\\Users\\10097443\\dover_data");
        File source = new File(folder, "dover.jpg");
        File destination = new File(folder, "dover_1.jpg");

        if (!folder.exists()) {
            folder.mkdirs();
        }

        Files.copy(source.toPath(), destination.toPath(),
                java.nio.file.StandardCopyOption.REPLACE_EXISTING);

        System.out.println("Image copied successfully.");
    }
}
