package br.com.ufg.inf.relprev.infraestrutura;

import br.com.caelum.vraptor.http.FormatResolver;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.view.DefaultPathResolver;

@Component
public class CustomPathResolver extends DefaultPathResolver {

    public CustomPathResolver(FormatResolver resolver) {
		super(resolver);
	}

	@Override
    protected String getPrefix() {
        return "/WEB-INF/paginas/";
    }
}