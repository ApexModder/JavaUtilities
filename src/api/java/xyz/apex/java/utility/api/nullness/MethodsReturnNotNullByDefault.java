package xyz.apex.java.utility.api.nullness;

import org.jetbrains.annotations.NotNull;

import javax.annotation.meta.TypeQualifierDefault;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * This annotation can be applied to a package, class or method to indicate that
 * the methods in that element return notnull by default unless there is:
 * <ul>
 *     <li>An explicit nullness annotation
 *     <li>The method overrides a method in a superclass (in which case the
 *     annotation of the corresponding parameter in the superclass applies)
 *     <li>There is a default parameter annotation (like {@link MethodsReturnNullableByDefault})
 *     applied to a more tightly nested element.
 * </ul>
 *
 * @see NotNull
 */
@Documented
@NotNull
@TypeQualifierDefault(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodsReturnNotNullByDefault
{ }