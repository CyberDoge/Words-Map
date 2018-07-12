package org.cd.project.words_map;

import org.cd.project.words_map.service.MapBuilderImpl;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlgorithmTest {
    @Test
    void test() {
        var mapBuilder = new MapBuilderImpl();
        String s = "ААА АААА ааа аааа абва аба";
        var res = mapBuilder.sortLine(s);
        System.out.println(res.toString());
        var expected = createTestMap(new Character[]{'а'}, "АААА", "ААА", "аба", "абва");
        System.out.println(expected.toString());
        for (var key : expected.keySet()) {
            assertTrue(res.containsKey(key));
            Iterator iterator = res.get(key).iterator();
            for (String str : expected.get(key)) {
                assertEquals(str, iterator.next());
            }
        }
    }

    private Map<Character, Set<String>> createTestMap(Character[] chars, String... str) {
        Map<Character, Set<String>> expected = new TreeMap<>();
        int last = 0;
        for (Character c : chars) {
            Set<String> someSet = new TreeSet<>((o1, o2) -> 1);
            expected.put(c, someSet);
            for (; last < str.length; last++) {
                if (!(c.equals(str[last].charAt(0)))) break;
                someSet.add(str[last]);
            }

        }
    }
}
