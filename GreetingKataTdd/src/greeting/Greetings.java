package greeting;

import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Greetings {
    public String greet(String... names) {
        if (names == null || names.length == 0) return "Hello, my friend.";
        if (names.length == 1 && isUppercase(names[0])) return "HELLO " + names[0] + "!";

        StringBuilder greetingText = new StringBuilder();
        Pair<List<String>, Queue<String>> uppercaseLowercase = splitUppercaseLowercase(names);
        List<String> lowercaseNames = uppercaseLowercase.getKey();
        Queue<String> uppercaseNames = uppercaseLowercase.getValue();

        if (lowercaseNames.size() > 0) {
            greetingText.append("Hello");
            for (int i = 0; i < lowercaseNames.size() - 1; i++) {
                greetingText.append(", ").append(lowercaseNames.get(i));
            }
            greetingText.append((lowercaseNames.size() > 1 ? " and " : ", ")).append(lowercaseNames.get(lowercaseNames.size() - 1)).append(".");
        } else {
            greetingText.append(greet(uppercaseNames.poll()));
        }

        while (uppercaseNames.size() > 0) {
            greetingText.append(" AND ").append(greet(uppercaseNames.poll()));
        }

        return greetingText.toString();
    }

    private Pair<List<String>, Queue<String>> splitUppercaseLowercase(String[] names) {
        List<String> lowercaseNames = new ArrayList<>();
        Queue<String> uppercaseNames = new ConcurrentLinkedQueue<>();
        for (String name : names) {
            boolean isCompound = name.matches("\"(.*)\"");
            if (isCompound) name = name.replaceAll("\"", "");
            boolean hasMultipleNames = name.contains(",");
            if (hasMultipleNames && !isCompound) {
                Collections.addAll(lowercaseNames, Arrays.stream(name.split(",")).map(String::trim).toArray(String[]::new));
                continue;
            }

            if (isUppercase(name)) uppercaseNames.add(name);
            else lowercaseNames.add(name);
        }
        return new Pair<>(lowercaseNames, uppercaseNames);
    }

    private boolean isUppercase(String name) {
        return name.equals(name.toUpperCase());
    }
}
