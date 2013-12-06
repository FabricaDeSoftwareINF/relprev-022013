package br.ufg.inf.es.relprev.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.download.Download;
import br.com.caelum.vraptor.interceptor.download.FileDownload;
import br.ufg.inf.es.relprev.annotation.NaoAutenticado;
import br.ufg.inf.es.relprev.cdn.CDN;
import br.ufg.inf.es.relprev.client.dominio.Anexo;
import br.ufg.inf.es.relprev.client.dominio.RelatorioPrevencao;
import br.ufg.inf.es.relprev.client.http.exception.RequestException;

import java.io.File;
import java.util.logging.Logger;

/**
 * User: halisson
 */
@Resource
public class CDNController {
    private final Result result;

    public CDNController(Result result) {
        this.result = result;
    }

    @NaoAutenticado
    @Get("/cdn/{relprev_id}/{path_anexo}")
    public Download download(String relprev_id, String path_anexo) throws RequestException {
        RelatorioPrevencao relprev = (RelatorioPrevencao) new RelatorioPrevencao().get(new Integer(relprev_id));
        logger.info("Obtendo arquivo " + path_anexo + " do relprev " + relprev_id);
        FileDownload fileDownload = null;
        for (Anexo anexo : relprev.getAnexos()) {
            logger.info("tentando " + path_anexo + " com " + anexo.getPathAnexo());
            if (anexo.getPathAnexo().equals(path_anexo)) {
                File file = CDN.obtenhaFileComCaminhoCompleto(anexo.getPathAnexo());
                fileDownload = new FileDownload(file, anexo.getMimeType(), anexo.getPathAnexo(), true);
            }
        }

        if (fileDownload == null) {
            result.notFound();
        }
        return fileDownload;
    }

    final Logger logger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
}
