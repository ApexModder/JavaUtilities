package xyz.apex.java.utility.api.nullness;

import org.jetbrains.annotations.Nullable;

import java.lang.annotation.*;

/**
 * An alternative to {@link Nullable} which works on type parameters (J8 feature).
 */
@Documented
@Nullable
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE, ElementType.TYPE_PARAMETER })
public @interface NullableType
{ }