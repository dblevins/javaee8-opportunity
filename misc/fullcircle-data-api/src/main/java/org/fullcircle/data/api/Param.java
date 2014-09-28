package org.fullcircle.data.api;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

@Target({PARAMETER})
@Retention(SOURCE)
public @interface Param {
    java.lang.String value();
}