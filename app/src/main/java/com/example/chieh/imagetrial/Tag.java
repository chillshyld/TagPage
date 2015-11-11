package com.example.chieh.imagetrial;

/**
 * Created by Chieh on 11/8/15 AD.
 */
public class Tag {
    String tagName;
    int iconId;


    public Tag(String tagName, int iconId) {
        this.tagName = tagName;
        this.iconId = iconId;
    }

    public int getIconId() {
        return iconId;
    }

    @Override
    public String toString() {
        return
                tagName + ' ' +
                " " + iconId;
    }
}
