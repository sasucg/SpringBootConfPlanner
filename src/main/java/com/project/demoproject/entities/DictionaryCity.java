package com.project.demoproject.entities;

public class DictionaryCity {
    public int getDictionaryCityId() {
        return DictionaryCityId;
    }

    public void setDictionaryCityId(int dictionaryCityId) {
        DictionaryCityId = dictionaryCityId;
    }

    public int getDictionaryDistrictId() {
        return DictionaryDistrictId;
    }

    public void setDictionaryDistrictId(int dictionaryDistrictId) {
        DictionaryDistrictId = dictionaryDistrictId;
    }

    public String getDictionaryCityName() {
        return DictionaryCityName;
    }

    public void setDictionaryCityName(String dictionaryCityName) {
        DictionaryCityName = dictionaryCityName;
    }

    public DictionaryCity(int dictionaryCityId, int dictionaryDistrictId, String dictionaryCityName) {
        DictionaryCityId = dictionaryCityId;
        DictionaryDistrictId = dictionaryDistrictId;
        DictionaryCityName = dictionaryCityName;
    }

    public DictionaryCity() {
    }

    private int DictionaryCityId;
    private int DictionaryDistrictId;
    private String DictionaryCityName;
}
