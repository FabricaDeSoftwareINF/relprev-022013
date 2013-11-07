package br.ufg.inf.model.support.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Payload;
import javax.validation.constraints.Pattern;

/**
 * {@link Annotation} para validação de padrão de número de telefone
 * 
 * @created 02/11/2013
 * @author Bruno César Ribeiro e Silva - <a
 *         href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@Documented
@Target({ANNOTATION_TYPE, FIELD, PARAMETER})
@Retention(RUNTIME)
@Pattern(regexp = "([1-9]{2})?([0-9]{8,9})")
public @interface Telefone {

	String message() default "{validation.Telefone.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
