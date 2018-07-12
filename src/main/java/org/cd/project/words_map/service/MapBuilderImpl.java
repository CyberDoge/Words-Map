package org.cd.project.words_map.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MapBuilderImpl implements MapBuilder {

    @Test
    void test() {
//        String s = "сапог сарай арбуз болт бокс биржа аБбаа абаа      авава аАааа ааааа ааба";
//        String s = "ААА АААА ааа аааа абва аба";
        String s = "ААА АААА ааа аааа абва аба";
        var res = sortLine(s);
        var keySet = res.entrySet();

        for (var mySet : keySet) {
            if(mySet.getValue().size() < 2) continue;
            System.out.print(mySet.getKey() + " = {\n");
            for (String str : mySet.getValue()) {
                System.out.print(str + ", ");
            }
            System.out.println("\n}");
        }
        Map<Character, Set<String>> expected = new TreeMap<>();
        Set<String> m = new TreeSet<>((o1, o2) -> 1);
        m.add("АААА");
        m.add("аааа");
        m.add("ААА");
        m.add("ааа");
//        m.add("аба");
        m.add("абва");
        System.out.println(m.toString());
        expected.put('а', m);
        Assertions.assertEquals(expected, res);
    }

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
        Comparator<String> comp = (String o1, String o2) -> {
            int len1 = o1.toLowerCase().getBytes().length >> 1;
            int len2 = o2.toLowerCase().getBytes().length >> 1;
            int lim = Math.min(len1, len2);
            for (int k = 0; k < lim; k++) {
                //
                char c1 = (char) (o1.getBytes()[k]& 0xFF);
                char c2 = (char) (o2.getBytes()[k]& 0xFF);
                if (c1 != c2) {
                    return c1 - c2;
                }
            }
            return len2 - len1;
        };
        Comparator<String> comparator = Comparator.comparing(String::toString);
        comparator.thenComparingInt(String::length).reversed();
        return new TreeSet<>(comp);
    }
}

/*
  int len1 = length(value);
        int len2 = length(other);
        int lim = Math.min(len1, len2);
        for (int k = 0; k < lim; k++) {
            char c1 = getChar(value, k);
            char c2 = getChar(other, k);
            if (c1 != c2) {
                return c1 - c2;
            }
        }
        return len1 - len2;
 */