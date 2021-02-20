package com.haufe.challenge.controllers;

import com.haufe.challenge.domains.Character;
import com.haufe.challenge.domains.Info;
import com.haufe.challenge.services.CharacterService;
import com.haufe.challenge.wrappers.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/")
    public String showHomePage(Model model) {
        List<ResponseWrapper> responses = characterService.fetchResponses();
        List<Character> characters = new ArrayList<>();

        for (ResponseWrapper response: responses) {
            for (Character character: response.getResults()) {
                characters.add(character);
            }
        }

        Info characterTotalInfo = responses.get(0).getInfo();
        model.addAttribute("chars", characters);
        model.addAttribute("charsTotalInfo", characterTotalInfo);
        return "index";
    }
}
