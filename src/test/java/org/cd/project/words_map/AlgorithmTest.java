package org.cd.project.words_map;

import org.cd.project.words_map.service.MapBuilderImpl;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AlgorithmTest {


    @Test
    public void simpleTest() {
        var expected = createTestMap(new Character[]{'а'}, "ААААА", "ААААа", "абвга", "аава", "аяя", "аа", "ах");
        String s = "аа   абвга ААААА аяя аава ах  ААААа";
        test(expected, s);
    }


    @Test
    void offeredTest() {
        var mapBuilder = new MapBuilderImpl();
        String s = "сапог сарай арбуз болт бокс биржа";
        String expected = "[б=[биржа, бокс, болт], с=[сапог, сарай]]";
        var map = mapBuilder.sortLine(s);
        Iterator<Character> iterator = map.keySet().iterator();
        for (int i = 0; i < map.size(); i++) {
            if (map.get(iterator.next()).size() < 2) iterator.remove();
        }
        var str = new StringBuilder("[");
        for (var key : map.keySet()) {
            if (map.get(key).size() > 1)
                str.append(key).append("=").append(map.get(key)).append(", ");
        }
        var res = str.substring(0, str.length() - 2) + ']';
        System.out.println("res = " + res);
        assertEquals(expected, res);
    }

    private void test(Map<Character, Set<String>> expected, String s) {
        var mapBuilder = new MapBuilderImpl();

        var res = mapBuilder.sortLine(s);
        System.out.println("res =\t   " + res);
        System.out.println("expected = " + expected);
        for (var key : expected.keySet()) {
            assertTrue(res.containsKey(key));
            Iterator iterator = res.get(key).iterator();
            for (String str : expected.get(key)) {
                var next = iterator.next();
                assertEquals(str, next);
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
                if (Character.toLowerCase(c) != Character.toLowerCase(str[last].charAt(0))) break;
                someSet.add(str[last]);
            }

        }
        return expected;
    }
}
