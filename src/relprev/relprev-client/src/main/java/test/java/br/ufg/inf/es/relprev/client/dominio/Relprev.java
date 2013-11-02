package test.java.br.ufg.inf.es.relprev.client.dominio;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: halisson
 * Date: 11/2/13
 * Time: 2:17 AM
 */
public class Relprev {
    private String local;
    private Date data;
    private String pessoalEnvolvido;
    private String situacao;
    private List<File> anexos;
    private Relator relator;

    //TODO: Implementar método real que obtém Relprevs no WS
    public static List<Relprev> list() {
        List<Relprev> relatoriosFake = new ArrayList<Relprev>();
        for (int i = 1; i < 100; i++) {
            Relprev relprevFake = new Relprev();
            relprevFake.setData(new Date());
            relprevFake.setLocal("Local" + System.nanoTime());
            if (System.nanoTime() % 2 == 0) {
                Relator relatorFake = new Relator();
                relatorFake.setNome("relatorShow" + System.nanoTime());
                relatorFake.setContato("relatorShow" + System.nanoTime() + "@show.com");
                relprevFake.setRelator(relatorFake);
            }
            relatoriosFake.add(relprevFake);
        }
        return relatoriosFake;
    }

    //TODO: Implementar método real que salva estado do objeto no WS
    public boolean save() {
        return save(true);
    }

    //TODO: Método somente para ajudar enquanto método real não eh implementado
    public boolean save(Boolean retorno) {
        return retorno;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getPessoalEnvolvido() {
        return pessoalEnvolvido;
    }

    public void setPessoalEnvolvido(String pessoalEnvolvido) {
        this.pessoalEnvolvido = pessoalEnvolvido;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public List<File> getAnexos() {
        return anexos;
    }

    public void setAnexos(List<File> anexos) {
        this.anexos = anexos;
    }

    public Relator getRelator() {
        return relator;
    }

    public void setRelator(Relator relator) {
        this.relator = relator;
    }

    public String getContatoRelator() {
        if (relator != null) {
            return relator.getContato();
        }
        return "";
    }

    public String getNomeRelator() {
        if (relator != null) {
            return relator.getNome();
        }
        return "";
    }
}
