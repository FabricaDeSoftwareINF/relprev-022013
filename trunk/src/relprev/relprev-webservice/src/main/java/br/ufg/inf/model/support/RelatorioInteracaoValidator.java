package br.ufg.inf.model.support;

import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.ufg.inf.model.Encaminhamento;
import br.ufg.inf.model.ParecerSetor;
import br.ufg.inf.model.Resposta;

/**
 * Valida se a data do Relatório de Prevenção é mesmo anterior à data do Objeto
 * 
 * @created 24/11/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
public class RelatorioInteracaoValidator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {
        final Boolean isEncaminhamento = Encaminhamento.class.isAssignableFrom(clazz);
        final Boolean isParecer = ParecerSetor.class.isAssignableFrom(clazz);
        final Boolean isReposta = Resposta.class.isAssignableFrom(clazz);
        return isEncaminhamento || isParecer || isReposta;
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        if (target instanceof Encaminhamento) {
            final Encaminhamento encaminhamento = (Encaminhamento) target;
            final Date data = encaminhamento.getData();
            final Date dataRelPrev = encaminhamento.getRelPrev().getDataInsercaoAlteracao();
            if (data.before(dataRelPrev)) {
                errors.rejectValue("data", "validation.Encaminhamento.data.Future.message");
            }
        } else if (target instanceof ParecerSetor) {
            final ParecerSetor parecerSetor = (ParecerSetor) target;
            final Date data = parecerSetor.getData();
            final Date dataRelPrev = parecerSetor.getRelPrev().getDataInsercaoAlteracao();
            if (data.before(dataRelPrev)) {
                errors.rejectValue("data", "validation.ParecerSetor.data.Future.message");
            }
        } else {
            final Resposta resposta = (Resposta) target;
            final Date data = resposta.getData();
            final Date dataRelPrev = resposta.getRelPrev().getDataInsercaoAlteracao();
            if (data.before(dataRelPrev)) {
                errors.rejectValue("data", "validation.Resposta.data.Future.message");
            }
        }
    }

}
