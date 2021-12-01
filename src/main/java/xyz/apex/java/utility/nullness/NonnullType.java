package xyz.apex.java.utility.nullness;

import javax.annotation.Nonnull;
import java.lang.annotation.*;

/**
 * An alternative to {@link Nonnull} which works on type parameters (J8 feature).
 * @since 1.0.0-J8
 */
@Documented
@Nonnull
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE, ElementType.TYPE_PARAMETER })
public @interface NonnullType
{ }
