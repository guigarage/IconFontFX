package com.guigarage.icon.fa;

import com.guigarage.icon.FontIcon;

/**
 * Created by hendrikebbers on 07.09.15.
 */
public enum FontAwesomeIcon implements FontIcon {
    FA_MAGIC("fa-magic",'\uf0D0');

    private String name;

    private char code;

    FontAwesomeIcon(String name, char code) {
        this.name = name;
        this.code = code;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public char getCode() {
        return code;
    }
}
