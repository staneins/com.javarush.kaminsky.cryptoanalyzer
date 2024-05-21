package com.javarush.cryptoanalyzer.kaminsky;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Validator {

    public boolean isValidKey(int key, char[] alphabet) {
        return key > 0 && key < alphabet.length;
    }

    public boolean isFileExists(String filePath) {
        Path file = Paths.get(filePath);
        return Files.exists(file);
    }

    public boolean contains(char[] ALPHABET, char neededCharacter) {
        String alphabet = new String(ALPHABET);
        return (alphabet.indexOf(neededCharacter) != - 1);
    }
    public int findPosition(char[] alphabet, char character) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == character) {
                return i;
            }
        }
        throw new IllegalArgumentException("Character not found in alphabet");
    }
}
