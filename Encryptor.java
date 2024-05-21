package com.javarush.cryptoanalyzer.kaminsky;

public class Encryptor {
    static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};
    static final char[] CAPITALALPHABET = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З',
            'И', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ',
            'Ъ', 'Ы', 'Ь', 'Э', 'Я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};
    private final String outputPath = "/run/media/philipk/68220e73-ac0a-41b6-b3bb-cb3b9497ba49/git/com.javarush.cryptoanalyzer.service/resources";
    Validator validator = new Validator();

    public char[] encrypt(char[] text, int timesNumber) {

        if (!validator.isValidKey(timesNumber, text)) {
            throw new IllegalArgumentException("Invalid key!");
        }

        char[] outputCharArray = new char[text.length];

        for (int i = 0; i < text.length; i++) {
            char character = text[i];
            if (validator.contains(ALPHABET, character)) {
                int originalPosition = validator.findPosition(ALPHABET, character);
                int newPosition = (originalPosition + timesNumber) % ALPHABET.length;
                outputCharArray[i] = ALPHABET[newPosition];
            } else if (validator.contains(CAPITALALPHABET, character)) {
                int originalPosition = validator.findPosition(CAPITALALPHABET, character);
                int newPosition = (originalPosition + timesNumber) % CAPITALALPHABET.length;
                outputCharArray[i] = CAPITALALPHABET[newPosition];
            } else {
                outputCharArray[i] = character;
            }
        }
        return outputCharArray;
    }

    public char[] decrypt(char[] text, int timesNumber) {
        return encrypt(text, ALPHABET.length - (timesNumber % ALPHABET.length));
    }
}


