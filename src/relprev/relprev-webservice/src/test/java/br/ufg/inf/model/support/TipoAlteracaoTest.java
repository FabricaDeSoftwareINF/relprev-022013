package br.ufg.inf.model.support;

import org.junit.Assert;
import org.junit.Test;

/**
 * Teste para valores dos tipos de alteração ({@link TipoAlteracao})
 * <p />
 * {@link #testTipoNumericoCREATE()} deve retornar {@code 0} <br />
 * {@link #testTipoNumericoUPDATE()} deve retornar {@code 1} <br />
 * {@link #testTipoNumericoDELETE()} deve retornar {@code 2} <br />
 * {@link #testDescricaoCREATE()} deve retornar {@code Criação} <br />
 * {@link #testDescricaoUPDATE()} deve retornar {@code Atualização} <br />
 * {@link #testDescricaoDELETE()} deve retornar {@code Remoção} <br />
 * {@link #testFromTipoCREATE()} deve retornar {@link TipoAlteracao#CREATE} <br />
 * {@link #testFromTipoUPDATE()} deve retornar {@link TipoAlteracao#UPDATE} <br />
 * {@link #testFromTipoDELETE()} deve retornar {@link TipoAlteracao#DELETE} <br />
 * 
 * @created 05/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
public class TipoAlteracaoTest {

    @Test
    public void testTipoNumericoCREATE() {
        Assert.assertEquals(TipoAlteracao.CREATE.getTipo(), Integer.valueOf(0));
    }

    @Test
    public void testTipoNumericoUPDATE() {
        Assert.assertEquals(TipoAlteracao.UPDATE.getTipo(), Integer.valueOf(1));
    }

    @Test
    public void testTipoNumericoDELETE() {
        Assert.assertEquals(TipoAlteracao.DELETE.getTipo(), Integer.valueOf(2));
    }

    @Test
    public void testDescricaoCREATE() {
        Assert.assertEquals(TipoAlteracao.CREATE.getDescricao(), "Criação");
    }

    @Test
    public void testDescricaoUPDATE() {
        Assert.assertEquals(TipoAlteracao.UPDATE.getDescricao(), "Atualização");
    }

    @Test
    public void testDescricaoDELETE() {
        Assert.assertEquals(TipoAlteracao.DELETE.getDescricao(), "Remoção");
    }

    @Test
    public void testFromTipoCREATE() {
        Assert.assertEquals(TipoAlteracao.fromTipo(0), TipoAlteracao.CREATE);
    }

    @Test
    public void testFromTipoUPDATE() {
        Assert.assertEquals(TipoAlteracao.fromTipo(1), TipoAlteracao.UPDATE);
    }

    @Test
    public void testFromTipoDELETE() {
        Assert.assertEquals(TipoAlteracao.fromTipo(2), TipoAlteracao.DELETE);
    }

    @Test
    public void testFromTipoNotFound() {
        Assert.assertEquals(TipoAlteracao.fromTipo(4), null);
    }

}
