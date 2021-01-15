package com.project.demoproject.entities;

public class DictionaryConferenceCategory {
    public int getDictionaryConferenceCategoryId() {
        return DictionaryConferenceCategoryId;
    }

    public void setDictionaryConferenceCategoryId(int dictionaryConferenceCategoryId) {
        DictionaryConferenceCategoryId = dictionaryConferenceCategoryId;
    }

    public String getDictionaryConferenceCategoryName() {
        return DictionaryConferenceCategoryName;
    }

    public void setDictionaryConferenceCategoryName(String dictionaryConferenceCategoryName) {
        DictionaryConferenceCategoryName = dictionaryConferenceCategoryName;
    }

    public DictionaryConferenceCategory() {
    }

    private int DictionaryConferenceCategoryId;
    private String DictionaryConferenceCategoryName;
}
