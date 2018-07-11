package org.cd.project.words_map.service;

import java.util.Map;

public interface MapBuilder {
    Map<Character, String> sortLine(String line);
}
