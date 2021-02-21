package com.haufe.challenge.services;

import com.haufe.challenge.domains.Character;
import com.haufe.challenge.enums.API;
import com.haufe.challenge.wrappers.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<ResponseWrapper> fetchAllCharactersAndInfo() {
/*        Although restTemplate will be deprecated "soon", I still prefer it compared to WebClient :).
          Furthermore, normally I would have created a simple Model character which would have not included not needed info such as the episode list and convert the characters to the model before returning it.
          The reason behind this is that such information is not shown in the index page for all listed characters. It is not wise to return not used info to our views. Not implementing it due to time constraints.*/
        List<ResponseWrapper> responseWrapperList = new ArrayList<>();
        final int pagesSize;

        // Initial request to retrieve the page size.
        ResponseWrapper responseWrapper = restTemplate.getForObject(API.RETRIEVE_CHARACTERS_AT_SPECIFIC_PAGE.toString() + "1", ResponseWrapper.class);
        responseWrapperList.add(responseWrapper);
        pagesSize = responseWrapper.getInfo().getPages();
        // The API returns paginated results, 20 characters per page. Looping through all pages to retrieve all sets of characters.
        for (int i = 2 ; i <= pagesSize ; i++) {
            responseWrapper = restTemplate.getForObject(API.RETRIEVE_CHARACTERS_AT_SPECIFIC_PAGE.toString() + i, ResponseWrapper.class);
            responseWrapperList.add(responseWrapper);
        }
        return responseWrapperList;
    }

    @Override
    public Character fetchSingleCharacter(int charId) {
        Character character = restTemplate.getForObject(API.RETRIEVE_SPECIFIC_CHARACTER.toString() + charId, Character.class);
        return character;
    }
}
