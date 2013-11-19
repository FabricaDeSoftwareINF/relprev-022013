package br.ufg.inf.model.divop;

import javax.persistence.Table;

import br.ufg.inf.model.support.AbstractEntity;
import br.ufg.inf.model.support.annotation.Hiddenable;
import br.ufg.inf.model.support.annotation.Updatable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * 
 * @created 19/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
//@Entity
@Hiddenable
@Table(name = "divulgacao_taxonomia_divop")
@JsonInclude(Include.NON_EMPTY)
@Updatable(newinsert = true, updatable = false)
public class DivulgacaoTaxonomiaDIVOP extends AbstractEntity<DivulgacaoTaxonomiaDIVOP> {

    private static final long serialVersionUID = -2979666728656186867L;

}
