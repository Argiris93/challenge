package com.haufe.challenge.services;

import com.haufe.challenge.domains.Character;
import com.haufe.challenge.wrappers.ResponseWrapper;

import java.util.List;

public interface CharacterService {

    List<ResponseWrapper> fetchAllCharactersAndInfo();
    Character fetchSingleCharacter(int charId);
}
