package com.haufe.challenge.services;

import com.haufe.challenge.wrappers.ResponseWrapper;

import java.util.List;

public interface CharacterService {

    List<ResponseWrapper> fetchResponses();
}
