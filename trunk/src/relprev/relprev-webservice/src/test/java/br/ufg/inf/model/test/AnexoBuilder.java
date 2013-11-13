package br.ufg.inf.model.test;

import org.springframework.test.util.ReflectionTestUtils;

import br.ufg.inf.model.support.Anexo;

/**
 * Classe para facilitar a criação de instâncias de Anexo usadas como mock nos testes
 * 
 * @created 12/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 * @see Anexo
 */
public class AnexoBuilder {

    private final Anexo anexo;

    public AnexoBuilder() {
        this.anexo = new Anexo();
    }

    public AnexoBuilder id(final Long id) {
        ReflectionTestUtils.setField(this.anexo, "id", id);
        return this;
    }

    public AnexoBuilder mimetype(final String mimeType) {
        ReflectionTestUtils.setField(this.anexo, "mimeType", mimeType);
        return this;
    }

    public AnexoBuilder path(final String path) {
        ReflectionTestUtils.setField(this.anexo, "pathAnexo", path);
        return this;
    }

    public Anexo build() {
        return this.anexo;
    }

}
