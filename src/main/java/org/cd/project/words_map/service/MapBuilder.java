package org.cd.project.words_map.service;

import java.util.Map;
import java.util.Set;

public interface MapBuilder {
    Map<Character, Set<String>> sortLine(String line);
}
