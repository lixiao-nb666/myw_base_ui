package com.newbee.myw_base_ui_lib.bean;

import java.io.Serializable;

public class MenuBean implements Serializable {
    private int type;
    private String showText;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getShowText() {
        return showText;
    }

    public void setShowText(String showText) {
        this.showText = showText;
    }

    @Override
    public String toString() {
        return "MenuBean{" +
                "type=" + type +
                ", showText='" + showText + '\'' +
                '}';
    }
}
