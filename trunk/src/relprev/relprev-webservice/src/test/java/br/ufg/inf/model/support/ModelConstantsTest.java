package br.ufg.inf.model.support;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Test;

/**
 * Testes para validar se os valores das contantes para o Modelo
 * 
 * @created 29/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
public class ModelConstantsTest {

    @Test
    public void testCOLUMN_SIZE_2() {
        assertEquals(ModelConstants.COLUMN_SIZE_2, 2);
    }

    @Test
    public void testCOLUMN_SIZE_15() {
        assertEquals(ModelConstants.COLUMN_SIZE_15, 15);
    }

    @Test
    public void testCOLUMN_SIZE_20() {
        assertEquals(ModelConstants.COLUMN_SIZE_20, 20);
    }

    @Test
    public void testCOLUMN_SIZE_30() {
        assertEquals(ModelConstants.COLUMN_SIZE_30, 30);
    }

    @Test
    public void testCOLUMN_SIZE_40() {
        assertEquals(ModelConstants.COLUMN_SIZE_40, 40);
    }

    @Test
    public void testCOLUMN_SIZE_45() {
        assertEquals(ModelConstants.COLUMN_SIZE_45, 45);
    }

    @Test
    public void testCOLUMN_SIZE_50() {
        assertEquals(ModelConstants.COLUMN_SIZE_50, 50);
    }

    @Test
    public void testCOLUMN_SIZE_60() {
        assertEquals(ModelConstants.COLUMN_SIZE_60, 60);
    }

    @Test
    public void testCOLUMN_SIZE_120() {
        assertEquals(ModelConstants.COLUMN_SIZE_120, 120);
    }

    @Test
    public void testCOLUMN_SIZE_600() {
        assertEquals(ModelConstants.COLUMN_SIZE_600, 600);
    }

    @Test
    public void testCOLUMN_SIZE_5000() {
        assertEquals(ModelConstants.COLUMN_SIZE_5000, 5000);
    }

    @Test
    public void testFIELD_SIZE_1() {
        assertEquals(ModelConstants.FIELD_SIZE_1, 1);
    }

    @Test
    public void testFIELD_SIZE_15() {
        assertEquals(ModelConstants.FIELD_SIZE_15, 15);
    }

    @Test
    public void testFIELD_SIZE_20() {
        assertEquals(ModelConstants.FIELD_SIZE_20, 20);
    }

    @Test
    public void testFIELD_SIZE_30() {
        assertEquals(ModelConstants.FIELD_SIZE_30, 30);
    }

    @Test
    public void testFIELD_SIZE_40() {
        assertEquals(ModelConstants.FIELD_SIZE_40, 40);
    }

    @Test
    public void testFIELD_SIZE_45() {
        assertEquals(ModelConstants.FIELD_SIZE_45, 45);
    }

    @Test
    public void testFIELD_SIZE_50() {
        assertEquals(ModelConstants.FIELD_SIZE_50, 50);
    }

    @Test
    public void testFIELD_SIZE_60() {
        assertEquals(ModelConstants.FIELD_SIZE_60, 60);
    }

    @Test
    public void testFIELD_SIZE_600() {
        assertEquals(ModelConstants.FIELD_SIZE_600, 600);
    }

    @Test
    public void testTELEFONE_REGEX() {
        assertEquals(ModelConstants.TELEFONE_REGEX, "([1-9]{2})?([0-9]{8,9})");
    }

    @Test
    public void testConstructorIsPrivate() throws Exception {
        final Constructor<ModelConstants> constructor = ModelConstants.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }

}
