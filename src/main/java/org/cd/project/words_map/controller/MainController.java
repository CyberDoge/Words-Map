package org.cd.project.words_map.controller;

import org.cd.project.words_map.service.MapBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.Set;

@Controller
public class MainController {

    private MapBuilder mapBuilder;

    @Autowired
    public void setMapBuilder(MapBuilder mapBuilder) {
        this.mapBuilder = mapBuilder;
    }

    @RequestMapping(name = "/", method = RequestMethod.GET)
    public String mainPage() {
        return "index.html";
    }

    @RequestMapping(name = "/", method = RequestMethod.POST)
    public @ResponseBody
    Map<Character, Set<String>> result(@RequestParam String res) {
        return mapBuilder.sortLine(res);
    }
}
