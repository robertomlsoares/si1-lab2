package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Anuncio {

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

    public Anuncio() {
    }

    public Anuncio(String titulo, String descricao, String cidade, String bairro, String instrumentos, String
            estilos, String estilosBanidos, String contatos, String interesse) throws Exception {
        validaParametros(titulo, descricao, cidade, bairro, instrumentos, contatos, interesse);

        this.titulo = titulo;
        this.descricao = descricao;
        this.cidade = cidade;
        this.bairro = bairro;
        this.instrumentos = instrumentos;
        this.estilos = estilos;
        this.estilosBanidos = estilosBanidos;
        this.contatos = contatos;
        this.interesse = interesse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private void validaParametros(String titulo, String descricao, String cidade, String bairro, String instrumentos,
                                  String contatos, String interesse) throws Exception {
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
}
