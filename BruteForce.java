package com.javarush.cryptoanalyzer.kaminsky;

import java.util.HashMap;
import java.util.Map;

public class BruteForce {
    Encryptor encryptor = new Encryptor();
    Validator validator = new Validator();

    public char[] decryptByBruteForce(char[] encryptedText) {
        Map<Character, Integer> mostFrequentChars = new HashMap<>();
        for (Character character : encryptedText) {
            if (mostFrequentChars.containsKey(character)) {
                mostFrequentChars.put(character, mostFrequentChars.get(character) + 1);
            } else {
                mostFrequentChars.put(character, 1);
            }
        }

        int maxValue = 0;
        char decryptedSpaceChar = ' ';

        for (Map.Entry entry : mostFrequentChars.entrySet()) {
            if (maxValue < (int) entry.getValue()) {
                maxValue = (int) entry.getValue();
            }
        }

        for (Map.Entry entry : mostFrequentChars.entrySet()) {
            if (maxValue == (int) entry.getValue()) {
                decryptedSpaceChar = (char) entry.getKey();
                break;
            }
        }

        int shift;

        if (Character.isLowerCase(decryptedSpaceChar)) {
            shift = (Encryptor.ALPHABET.length - 1) - validator.findPosition(Encryptor.ALPHABET, decryptedSpaceChar);
        } else {
            shift = (Encryptor.CAPITALALPHABET.length - 1) - validator.findPosition(Encryptor.CAPITALALPHABET, decryptedSpaceChar);
        }

        return encryptor.encrypt(encryptedText, shift);
    }
}
