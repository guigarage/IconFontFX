package com.guigarage.icon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.logging.Logger;

/**
 * Created by hendrikebbers on 07.09.15.
 */
public class IconFontManager {

    private static final IconFontManager INSTANCE = new IconFontManager();

    private static final Logger logger = Logger.getLogger(IconFontManager.class.getName());

    private List<IconFont> fonts;

    private IconFontManager() {
        fonts = new ArrayList<>();
        ServiceLoader<IconFont> serviceLoader = ServiceLoader.load(IconFont.class);
        Iterator<IconFont> fontsIterator = serviceLoader.iterator();
        while(fontsIterator.hasNext()) {
            IconFont font = fontsIterator.next();
            logger.fine("Found " + IconFont.class.getName() + " " + font.getName() + " (" + font.getClass() + ")");
            fonts.add(font);
        }
    }

    public FontIcon getIcon(String iconName) {
        for(IconFont provider : fonts) {
            if(provider.supports(iconName)) {
                FontIcon definition = provider.getIcon(iconName);
                if(definition != null) {
                    return definition;
                }
            }
        }
        return null;
    }

    public static IconFontManager getInstance() {
        return INSTANCE;
    }
}
