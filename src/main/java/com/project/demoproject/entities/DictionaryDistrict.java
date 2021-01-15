package com.project.demoproject.entities;

public class DictionaryDistrict {
    public DictionaryDistrict(int dictionaryDistrictId, String dictionaryDistrictName, String dictionaryDistrictCode) {
        DictionaryDistrictId = dictionaryDistrictId;
        DictionaryDistrictName = dictionaryDistrictName;
        DictionaryDistrictCode = dictionaryDistrictCode;
    }

    public int getDictionaryDistrictId() {
        return DictionaryDistrictId;
    }

    public void setDictionaryDistrictId(int dictionaryDistrictId) {
        DictionaryDistrictId = dictionaryDistrictId;
    }

    public String getDictionaryDistrictName() {
        return DictionaryDistrictName;
    }

    public void setDictionaryDistrictName(String dictionaryDistrictName) {
        DictionaryDistrictName = dictionaryDistrictName;
    }

    public String getDictionaryDistrictCode() {
        return DictionaryDistrictCode;
    }

    public void setDictionaryDistrictCode(String dictionaryDistrictCode) {
        DictionaryDistrictCode = dictionaryDistrictCode;
    }

    public DictionaryDistrict() {
    }

    private int DictionaryDistrictId;
    private String DictionaryDistrictName;
    private String DictionaryDistrictCode;
}
