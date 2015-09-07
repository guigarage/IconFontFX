package com.guigarage.icon;

import javafx.css.ParsedValue;
import javafx.css.StyleConverter;
import javafx.scene.text.Font;

/**
 * Created by hendrikebbers on 07.09.15.
 */
public class FontIconStyleConverter extends StyleConverter<String, FontIcon> {

    @Override
    public FontIcon convert(ParsedValue<String, FontIcon> value, Font font) {
        String iconName = value.getValue();
        return IconFontManager.getInstance().getIcon(iconName);
    }
}
