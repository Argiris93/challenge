package com.haufe.challenge.enums;

public enum API {
    RETRIEVE_CHARACTERS_AT_SPECIFIC_PAGE("https://rickandmortyapi.com/api/character?page="),
    RETRIEVE_SPECIFIC_CHARACTER("https://rickandmortyapi.com/api/character/");

    private final String url;

    private API(String url) {
        this.url = url;
    }
    @Override
    public String toString() {
        return url;
    }
}
