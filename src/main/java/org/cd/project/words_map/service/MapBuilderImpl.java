package org.cd.project.words_map.service;

import java.util.*;


public class MapBuilderImpl implements MapBuilder {


    @Override
    public Map<Character, Set<String>> sortLine(String line) {
        var splitLine = line.split(" ");

        Map<Character, Set<String>> result = new TreeMap<>();

        for (var word : splitLine) {
            if (word.length() == 0)
                continue;
            Character firstLetter = Character.toLowerCase(word.charAt(0));
            var set = result.computeIfAbsent(firstLetter, k -> createTreeSet());
            set.add(word);
        }
        return result;
    }

    private Set<String> createTreeSet() {
        Comparator<String> comp = (String str1, String str2) -> {
            var str1Length = str1.length();
            var str2Length = str2.length();
            var limit = Math.min(str1Length, str2Length);
            for (int i = 0; i < limit; i++) {
                Character c1 = Character.toLowerCase(str1.charAt(i));
                Character c2 = Character.toLowerCase(str2.charAt(i));
                if (!c1.equals(c2)) return c1 - c2;
            }

            return str2Length - str1Length;
        };
        return new TreeSet<>(comp);
    }
}