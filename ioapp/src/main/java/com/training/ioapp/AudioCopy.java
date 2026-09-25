package com.training.ioapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.Path;

public class AudioCopy {

    public static void main(String[] args) throws IOException {
        Path source = Path.of("C:\\Users\\10097443\\dover_data\\dover.mp3");
        Path destination = Path.of("C:\\Users\\10097443\\dover_data\\dover_1.mp3");

        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Audio copied successfully.");
    }
}
