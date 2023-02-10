package dev.legaspicary.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OraChallenge {
    public static void main(String[] args) {
        scanAndFormatPassword();
    }

    public static void scanAndFormatPassword() {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        List<String> passwordLists = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            String passwordLine = scanner.nextLine().toLowerCase();
            passwordLists.add(passwordLine);
        }

        passwordLists.stream()
                .map(OraChallenge::formatPassword)
                .forEach(System.out::println);

        scanner.close();
    }

    public static String formatPassword(String str) {
        return prependAsterisksInLetter(removeVowels(str));
    }

    public static String prependAsterisksInLetter(String str) {
        StringBuilder builder = new StringBuilder();

        for (String letter : str.split("")) {
            builder.append("*" + letter);
        }

        return builder.toString();
    }

    public static String removeVowels(String str) {
        return str.replaceAll("[aeiou]", "");
    }
}