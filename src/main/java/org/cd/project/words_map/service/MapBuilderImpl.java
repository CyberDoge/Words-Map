package org.cd.project.words_map.service;

import org.springframework.stereotype.Component;

import java.util.*;

@Component("mapBuilder")
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
        Comparator<String> comparator = Comparator.comparingInt(String::length).reversed().thenComparing(String::compareTo);
        return new TreeSet<>(comparator);
    }
}