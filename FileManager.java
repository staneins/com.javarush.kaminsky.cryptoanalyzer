package com.javarush.cryptoanalyzer.kaminsky;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
    Validator validator = new Validator();

    public char[] readFile(String filePath) {
        Path path = Paths.get(filePath);
        byte[] bytes;
        if (!validator.isFileExists(path.toString())) {
            throw new RuntimeException("File doesn't exist!");
        }
        try {
            bytes = Files.readAllBytes(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new String(bytes, StandardCharsets.UTF_8).toCharArray();
    }

        public void writeFile(char[] content, String filePath)
    {
        Path path = Paths.get(filePath);
        byte[] bytes = new String(content).getBytes();
        try {
            Files.write(path, bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
