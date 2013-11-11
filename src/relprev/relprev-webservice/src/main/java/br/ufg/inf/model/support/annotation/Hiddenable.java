package br.ufg.inf.model.support.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Anotação que permite que o framework de persistência exclua logicamente um objeto
 * 
 * @created 09/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@Documented
@Target(TYPE)
@Retention(RUNTIME)
public @interface Hiddenable {

}
