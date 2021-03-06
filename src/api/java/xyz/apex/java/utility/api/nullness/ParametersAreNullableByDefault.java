package xyz.apex.java.utility.api.nullness;

import org.jetbrains.annotations.Nullable;

import javax.annotation.meta.TypeQualifierDefault;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * This annotation can be applied to a package, class or method to indicate that
 * the method parameters in that element are nullable by default unless there is:
 * <ul>
 *     <li>An explicit nullness annotation
 *     <li>The method overrides a method in a superclass (in which case the
 *     annotation of the corresponding parameter in the superclass applies)
 *     <li>There is a default parameter annotation (like {@link ParametersAreNotNullByDefault})
 *     applied to a more tightly nested element.
 * </ul>
 *
 * @see Nullable
 */
@Documented
@Nullable
@TypeQualifierDefault({ ElementType.PARAMETER, ElementType.TYPE_PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ParametersAreNullableByDefault
{ }