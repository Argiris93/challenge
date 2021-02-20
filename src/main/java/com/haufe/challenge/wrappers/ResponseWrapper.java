package com.haufe.challenge.wrappers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.haufe.challenge.domains.Character;
import com.haufe.challenge.domains.Info;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseWrapper {

    private Info info;
    private List<Character> results;

    public ResponseWrapper() {
        info = new Info();
        results = new ArrayList<>();
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Character> getResults() {
        return results;
    }

    public void setResults(List<Character> results) {
        this.results = results;
    }
}
