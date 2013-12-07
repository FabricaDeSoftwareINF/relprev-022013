package br.ufg.inf.model.util;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Test;

/**
 * Teste para classe ReflectionUtil
 * @author Raul
 *
 */
public class ReflectionUtilTest {
	
	@Test
    public void testConstructorIsPrivate() throws Exception {
      Constructor<ReflectionUtil> constructor = ReflectionUtil.class.getDeclaredConstructor();
      assertTrue(Modifier.isPrivate(constructor.getModifiers()));
      constructor.setAccessible(true);
      constructor.newInstance();
    }

}
