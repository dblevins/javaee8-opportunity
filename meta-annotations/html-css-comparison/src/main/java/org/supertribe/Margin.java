package org.supertribe;

public @interface Margin {
    int left() default 0;
    int right() default 0;
    int top() default 0;
    int bottom() default 0;
}
