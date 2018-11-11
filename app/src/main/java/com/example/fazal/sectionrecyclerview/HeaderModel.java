package com.example.fazal.sectionrecyclerview;

/**
 * Header Model Class.
 *
 * @version 1.0
 * @author Fazal Hussain
 */
public class HeaderModel implements Item {

    String title;

    public HeaderModel(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean isSection() {
        return true;
    }
}
