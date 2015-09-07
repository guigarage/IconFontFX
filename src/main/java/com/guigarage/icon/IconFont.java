package com.guigarage.icon;

import javafx.scene.text.Font;

import java.util.List;

public interface IconFont<I extends FontIcon> {

    public String getName();

    public Font getIconFont();

    public boolean supports(String iconName);

    public I getIcon(String iconName);

    public List<I> getAllIcons();
}
