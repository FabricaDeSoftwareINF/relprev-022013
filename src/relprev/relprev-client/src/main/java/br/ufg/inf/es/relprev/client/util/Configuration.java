package br.ufg.inf.es.relprev.client.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Classe que representa um arquivo de configuração {@code .properties}
 * 
 * @created 06/12/2013
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
public class Configuration {

    private Properties properties;

    private final String fileName;

    /**
     * Constrói uma configuração, de acordo com o nome do arquivo
     * 
     * @param fileName
     *            nome do arquivo, sem extensão
     */
    public Configuration(final String fileName) {
        this.fileName = fileName;
        this.loadConfiguration();
    }

    /**
     * Recupera de um {@code .properties} o valor da propriedade correspondente à chave informada
     * 
     * @param key
     *            a chave do valor recuperado
     * @return o valor correspondente à chave ou <code>null</code> se a chave
     *         não for encontrada.
     */
    public String getProperty(final String key) {
        final String property = this.properties.getProperty(key);
        if (property == null) {
            throw new RuntimeException("não existe no arquivo de configuração " + this.fileName + " a chave " + key);
        }
        return property;
    }

    /**
     * Recupera o nome do arquivo de configuração, já com a extensão {@code .properties}
     * 
     * @return {@link String} nome do arquivo de configuração
     */
    private String getConfigurationFileName() {
        return "/" + this.fileName + ".properties";
    }

    /**
     * Carrega do classpath o arquivo de configuração
     */
    private void loadConfiguration() {
        this.properties = new Properties();
        try {
            final InputStream is = Configuration.class.getResourceAsStream(this.getConfigurationFileName());
            if (is == null) {
                throw new IOException("Arquivo de configuração " + this.getConfigurationFileName() + " não pôde ser encontrado.");
            }
            this.properties.load(is);
            is.close();
        } catch (final IOException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

}
