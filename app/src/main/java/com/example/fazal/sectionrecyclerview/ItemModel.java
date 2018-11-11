package com.example.fazal.sectionrecyclerview;

/**
 * Item Model Class
 *
 * @author Fazal Hussain
 * @version 1.0
 */
public class ItemModel implements Item {

    String title;
    String subTitle;

    public ItemModel(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @Override
    public boolean isSection() {
        return false;
    }
}
