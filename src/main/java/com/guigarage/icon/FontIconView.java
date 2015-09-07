package com.guigarage.icon;

import javafx.beans.property.ObjectProperty;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.css.StyleableObjectProperty;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

public class FontIconView extends Control {

    private ObjectProperty<FontIcon> icon;

    public FontIconView() {
        this(null);
    }

    public FontIconView(FontIcon icon) {
        getStyleClass().add("icon-view");

        if (icon != null) {
            iconProperty().setValue(icon);
        }
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new FontIconViewSkin(this);
    }

    @Override
    public String getUserAgentStylesheet() {
        return FontIconView.class.getResource("fonticonview.css").toExternalForm();
    }

    public FontIcon getIcon() {
        return iconProperty().get();
    }

    public ObjectProperty<FontIcon> iconProperty() {
        if (icon == null) {
            icon = new StyleableObjectProperty<FontIcon>() {
                @Override
                public Object getBean() {
                    return FontIconView.this;
                }

                @Override
                public String getName() {
                    return "icon";
                }

                @Override
                public CssMetaData<? extends Styleable, FontIcon> getCssMetaData() {
                    return null;
                }
            };
        }
        return icon;
    }

    public void setIcon(FontIcon icon) {
        this.iconProperty().set(icon);
    }

    @Deprecated
    @Override
    protected/* do not make final */Boolean impl_cssGetFocusTraversableInitialValue() {
        return Boolean.FALSE;
    }

}
