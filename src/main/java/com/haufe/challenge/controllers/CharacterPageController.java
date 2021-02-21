package com.haufe.challenge.controllers;

import com.haufe.challenge.domains.Character;
import com.haufe.challenge.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterPageController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/character/{charId}")
    public Character showSingleCharacter(@PathVariable("charId") String charId) {
        int id = 1;
        try {
            id = Integer.parseInt(charId);
        }
        catch (NumberFormatException e) {
        }
        return characterService.fetchSingleCharacter(id);


    }
}
