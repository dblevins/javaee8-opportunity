package org.supertribe.style;

public @interface Font {

    int size() default 12;
    String weight() default "normal";
    String[] family() default {};
}
