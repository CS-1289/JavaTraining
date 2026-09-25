package com.training.ioapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.Path;

public class VideoCopy {

    public static void main(String[] args) throws IOException {
        Path source = Path.of("C:\\Users\\10097443\\dover_data\\dover.mp4");
        Path destination = Path.of("C:\\Users\\10097443\\dover_data\\dover_1.mp4");

        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Video copied successfully.");
    }
}
