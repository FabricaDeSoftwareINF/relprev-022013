package br.ufg.inf.es.relprev.cdn;

import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.ufg.inf.es.relprev.client.dominio.Anexo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

/**
 * User: halisson
 */
public class CDN {
    private final static Logger logger = Logger.getLogger("CDN");

    public static Set<Anexo> save(List<UploadedFile> files) {
        Set<Anexo> anexos = new HashSet<Anexo>();

        for (UploadedFile file : files) {
            try {
                Anexo anexo = new Anexo();
                anexo.setPathAnexo(file.getFileName());
                anexo.setMimeType(file.getContentType());

                File arquivo = obtenhaArquivoParaEscrever(anexo.getPathAnexo());
                persistaArquivoNoDisco(file.getFile(), arquivo);

                anexos.add(anexo);
            } catch (Exception e) {
                logger.severe(e.getMessage());
                e.printStackTrace();
            }
        }

        return anexos;
    }

    private static void persistaArquivoNoDisco(InputStream content, File arquivo) {
        try {
            BufferedInputStream bufferedInputStream = null;
            FileOutputStream fileOutputStream = null;

            bufferedInputStream = new BufferedInputStream(content);
            fileOutputStream = new FileOutputStream(arquivo);
            byte[] buffer = new byte[1024];
            int count;
            while ((count = bufferedInputStream.read(buffer)) > 0)
                fileOutputStream.write(buffer, 0, count);

            bufferedInputStream.close();
            fileOutputStream.close();
        } catch (Exception ex) {
            throw new IllegalStateException("Não foi possível persistir o anexo! " + ex.getStackTrace().toString());
        }
    }

    private static File obtenhaArquivoParaEscrever(String pathAnexo) {
        File arquivo = new File(obtenhaCaminhoCompletoDoArquivo(pathAnexo));
        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
            } catch (Exception ex) {
                throw new IllegalStateException("Não foi possível criar o arquivo para persistir o anexo! " + ex.getStackTrace().toString());
            }
        }

        return arquivo;
    }

    //    TODO: externalizar essa config
    public static String obtenhaDir() {
        return "/home/relprev/relatorios";
    }

    public static File obtenhaFileComCaminhoCompleto(String pathAnexo) {
        return new File(obtenhaCaminhoCompletoDoArquivo(pathAnexo));
    }

    private static String obtenhaCaminhoCompletoDoArquivo(String pathAnexo) {
        return obtenhaDir() + "/" + pathAnexo;
    }
}
