package com.guigarage.icon;

import javafx.scene.text.Font;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hendrikebbers on 07.09.15.
 */
public abstract class AbstractIconFont<I extends Enum<I> & FontIcon> implements IconFont<I> {

    private String name;

    private String prefix;

    private Class<I> iconEnumClass;

    private Font font;

    public AbstractIconFont(String name, String prefix, Class<I> iconEnumClass, String fontUrl) {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name mustn't be null or empty");
        }
        if(prefix == null || prefix.trim().isEmpty()) {
            throw new IllegalArgumentException("prefix mustn't be null or empty");
        }
        if(iconEnumClass == null) {
            throw new IllegalArgumentException("iconEnumClass mustn't be null");
        }
        this.name = name;
        this.prefix = prefix;
        this.iconEnumClass = iconEnumClass;

        font = Font.loadFont(fontUrl, 10);
        if(font == null) {
            throw new IllegalArgumentException("Can't load font for url " + fontUrl);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Font getIconFont() {
        return font;
    }

    @Override
    public boolean supports(String iconName) {
        return (iconName != null && iconName.startsWith(prefix));
    }

    @Override
    public I getIcon(String iconName) {
        if(iconName == null) {
            return null;
        }
        for(I icon : getAllIcons()) {
            if(icon.name().equals(iconName)) {
                return icon;
            }
        }
        return null;
    }

    @Override
    public List<I> getAllIcons() {
        return Arrays.asList(iconEnumClass.getEnumConstants());
    }
}
