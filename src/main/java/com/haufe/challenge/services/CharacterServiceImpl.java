package com.haufe.challenge.services;

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
    public List<ResponseWrapper> fetchResponses() {
        // Although restTemplate will be deprecated "soon", I still prefer it compared to WebClient :).
        List<ResponseWrapper> responseWrapperList = new ArrayList<>();
        ResponseWrapper responseWrapper = restTemplate.getForObject(API.RETRIEVE_CHARACTERS_AT_SPECIFIC_PAGE.toString() + "1", ResponseWrapper.class);
        responseWrapperList.add(responseWrapper);
        int pagesSize = responseWrapper.getInfo().getPages();

        for (int i = 2 ; i <= pagesSize ; i++) {
            responseWrapper = restTemplate.getForObject(API.RETRIEVE_CHARACTERS_AT_SPECIFIC_PAGE.toString() + i, ResponseWrapper.class);
            responseWrapperList.add(responseWrapper);
        }
        return responseWrapperList;
    }
}
