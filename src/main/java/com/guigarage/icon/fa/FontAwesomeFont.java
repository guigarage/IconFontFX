package com.guigarage.icon.fa;

import com.guigarage.icon.AbstractIconFont;

/**
 * Created by hendrikebbers on 07.09.15.
 */
public class FontAwesomeFont extends AbstractIconFont<FontAwesomeIcon> {

    private final static String NAME = "Font Awesome";

    private final static String PREFIX = "fa-";

    public FontAwesomeFont() {
        super(NAME, PREFIX, FontAwesomeIcon.class, FontAwesomeFont.class.getResource("fa.ttf").toExternalForm());
    }
}
