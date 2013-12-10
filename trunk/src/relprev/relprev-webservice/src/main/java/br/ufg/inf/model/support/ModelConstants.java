package br.ufg.inf.model.support;

/**
 * Constantes usadas no modelo de entidades para evitar violações {@code MAGIC NUMBER} do Sonar
 * 
 * @created 25/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
public final class ModelConstants {

    private ModelConstants() {}

    /**
     * Constante para coluna JPA de tamanho 2
     */
    public static final int COLUMN_SIZE_2 = 2;

    /**
     * Constante para coluna JPA de tamanho 15
     */
    public static final int COLUMN_SIZE_15 = 15;

    /**
     * Constante para coluna JPA de tamanho 20
     */
    public static final int COLUMN_SIZE_20 = 20;

    /**
     * Constante para coluna JPA de tamanho 30
     */
    public static final int COLUMN_SIZE_30 = 30;

    /**
     * Constante para coluna JPA de tamanho 40
     */
    public static final int COLUMN_SIZE_40 = 40;

    /**
     * Constante para coluna JPA de tamanho 45
     */
    public static final int COLUMN_SIZE_45 = 45;

    /**
     * Constante para coluna JPA de tamanho 50
     */
    public static final int COLUMN_SIZE_50 = 50;

    /**
     * Constante para coluna JPA de tamanho 60
     */
    public static final int COLUMN_SIZE_60 = 60;

    /**
     * Constante para coluna JPA de tamanho 120
     */
    public static final int COLUMN_SIZE_120 = 120;

    /**
     * Constante para coluna JPA de tamanho 600
     */
    public static final int COLUMN_SIZE_600 = 600;

    /**
     * Constante para coluna JPA de tamanho 5000
     */
    public static final int COLUMN_SIZE_5000 = 5000;

    /**
     * Constante para campo de tamanho mínimo ou máximo (bean validation) igual a 1
     */
    public static final int FIELD_SIZE_1 = 1;

    /**
     * Constante para campo de tamanho mínimo ou máximo (bean validation) igual a 15
     */
    public static final int FIELD_SIZE_15 = 15;

    /**
     * Constante para campo de tamanho mínimo ou máximo (bean validation) igual a 20
     */
    public static final int FIELD_SIZE_20 = COLUMN_SIZE_20;

    /**
     * Constante para campo de tamanho mínimo ou máximo (bean validation) igual a 30
     */
    public static final int FIELD_SIZE_30 = COLUMN_SIZE_30;

    /**
     * Constante para campo de tamanho mínimo ou máximo (bean validation) igual a 40
     */
    public static final int FIELD_SIZE_40 = COLUMN_SIZE_40;

    /**
     * Constante para campo de tamanho mínimo ou máximo (bean validation) igual a 45
     */
    public static final int FIELD_SIZE_45 = COLUMN_SIZE_45;

    /**
     * Constante para campo de tamanho mínimo ou máximo (bean validation) igual a 50
     */
    public static final int FIELD_SIZE_50 = COLUMN_SIZE_50;

    /**
     * Constante para campo de tamanho mínimo ou máximo (bean validation) igual a 60
     */
    public static final int FIELD_SIZE_60 = COLUMN_SIZE_60;

    /**
     * Constante para campo de tamanho mínimo ou máximo (bean validation) igual a 600
     */
    public static final int FIELD_SIZE_600 = COLUMN_SIZE_600;

    /**
     * Constante que representa o padrão de telefone (bean validation) a ser usado na aplicação
     */
    public static final String TELEFONE_REGEX = "([1-9]{2})?([0-9]{8,9})";

}
