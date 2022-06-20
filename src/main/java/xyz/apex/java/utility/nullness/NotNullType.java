package xyz.apex.java.utility.nullness;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.*;

/**
 * An alternative to {@link NotNull} which works on type parameters (J8 feature).
 */
@Documented
@NotNull
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE, ElementType.TYPE_PARAMETER })
public @interface NotNullType
{ }
