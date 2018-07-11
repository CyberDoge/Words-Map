package org.cd.project.words_map.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(name = "/", method = RequestMethod.GET)
    public String mainPage() {
        return "index.html";
    }

    @RequestMapping(name = "/", method = RequestMethod.POST)
    public void result(@RequestBody MultiValueMap<String, String> formData) {
        String str = formData.getFirst("words-array");


    }
}
