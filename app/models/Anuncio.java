package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Anuncio implements Comparable<Anuncio> {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column
    private String cidade;

    @Column
    private String bairro;

    @Column
    private String instrumentos;

    @Column
    private String estilos;

    @Column
    private String estilosBanidos;

    @Column
    private String contatos;

    @Column
    private String interesse;

    @Column
    private String codigo;

    @Column
    private boolean finalizado;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Conversa> conversas;

    @Temporal(TemporalType.DATE)
    private Date data = new Date();

    public Anuncio() {
        this.conversas = new ArrayList<>();
    }

    public Anuncio(String titulo, String descricao, String cidade, String bairro, String instrumentos, String
            estilos, String estilosBanidos, String contatos, String codigo, String interesse) throws Exception {
        validaParametros(titulo, descricao, cidade, bairro, instrumentos, contatos, codigo, interesse);

        this.titulo = titulo;
        this.descricao = descricao;
        this.cidade = cidade;
        this.bairro = bairro;
        this.instrumentos = instrumentos;
        this.estilos = estilos;
        this.estilosBanidos = estilosBanidos;
        this.contatos = contatos;
        this.codigo = codigo;
        this.interesse = interesse;
        this.finalizado = false;
        this.conversas = new ArrayList<>();
    }

    public List<Conversa> getConversas() {
        return conversas;
    }

    public void setConversas(List<Conversa> conversas) {
        this.conversas = conversas;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private void validaParametros(String titulo, String descricao, String cidade, String bairro, String instrumentos,
                                  String contatos, String codigo, String interesse) throws Exception {
        if (titulo == null || titulo.trim() == "") {
            throw new Exception("Não se pode criar um anúncio sem título.");
        }
        if (descricao == null || descricao.trim() == "") {
            throw new Exception("Não se pode criar um anúncio sem descrição.");
        }
        if (cidade == null || cidade.trim() == "") {
            throw new Exception("Não se pode criar um anúncio sem cidade.");
        }
        if (bairro == null || bairro.trim() == "") {
            throw new Exception("Não se pode criar um anúncio sem bairro.");
        }
        if (instrumentos == null || instrumentos.trim() == "") {
            throw new Exception("Não se pode criar um anúncio sem instrumentos.");
        }
        if (contatos == null || contatos.trim() == "") {
            throw new Exception("Não se pode criar um anúncio sem contatos.");
        }
        if (codigo == null || codigo.trim() == "") {
            throw new Exception("Não se pode criar um anúncio sem código.");
        }
        if (interesse == null || interesse.trim() == "") {
            throw new Exception("Não se pode criar um anúncio sem interesse.");
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getInstrumentos() {
        return instrumentos;
    }

    public void setInstrumentos(String instrumentos) {
        this.instrumentos = instrumentos;
    }

    public String getEstilos() {
        return estilos;
    }

    public void setEstilos(String estilos) {
        this.estilos = estilos;
    }

    public String getEstilosBanidos() {
        return estilosBanidos;
    }

    public void setEstilosBanidos(String estilosBanidos) {
        this.estilosBanidos = estilosBanidos;
    }

    public String getContatos() {
        return contatos;
    }

    public void setContatos(String contatos) {
        this.contatos = contatos;
    }

    public String getInteresse() {
        return interesse;
    }

    public void setInteresse(String interesse) {
        this.interesse = interesse;
    }

    public boolean isEstilosEmpty() {
        return this.estilos.length() == 0;
    }

    public boolean isEstilosBanidosEmpty() {
        return this.estilosBanidos.length() == 0;
    }

    public void fazerPergunta(String pergunta) {
        try {
            conversas.add(new Conversa(pergunta));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void responderPergunta(Long idConversa, String resposta, String codigo) throws Exception {
        if (!codigo.equals(this.codigo)) {
            throw new Exception("Somente quem tem o código do anúncio pode responder perguntas.");
        }

        for (Conversa conversa : conversas) {
            if (conversa.getId().equals(idConversa)) {
                try {
                    conversa.setResposta(resposta);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    @Override
    public int compareTo(Anuncio o) {
        return getId().compareTo(o.getId()) * (-1);
    }
}
