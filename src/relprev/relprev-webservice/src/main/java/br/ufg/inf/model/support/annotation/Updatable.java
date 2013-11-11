package br.ufg.inf.model.support.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Anotação para verificar se a entidade do modelo pode ser atualizada.<br />
 * Quando não, verifica se irá fazer um novo {@code insert} ou lançar exceção
 * 
 * @created 03/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@Documented
@Target(TYPE)
@Retention(RUNTIME)
public @interface Updatable {

    /**
     * (Opcional) Se a entidade pode ter seus valores atualizados. Default {@code true}
     */
    boolean updatable() default true;

    /**
     * (Opcional) Se a entidade, mesmo não sendo atualizável, deverá ter um novo insert para os valores. Default {@code false}
     */
    boolean newinsert() default false;

}
