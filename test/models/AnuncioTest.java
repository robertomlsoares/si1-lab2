package models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class AnuncioTest {

    private String titulo1;
    private String descricao1;
    private String cidade1;
    private String bairro1;
    private String instrumentos1;
    private String estilos1;
    private String estilosBanidos1;
    private String contatos1;
    private String interesse1;

    @Before
    public void setUp() {
        titulo1 = "Título1";
        descricao1 = "Descrição de teste";
        cidade1 = "Campina Grande";
        bairro1 = "Bodocongó";
        instrumentos1 = "Violão, Guitarra";
        estilos1 = "Rock, Jazz, Blues";
        estilosBanidos1 = "Pagode, Funk";
        contatos1 = "teste@gmail.com";
        interesse1 = "Formar Banda";
    }

    @Test
    public void deveCriarAnuncioSemErros() {
        try {
            new Anuncio(titulo1, descricao1, cidade1, bairro1, instrumentos1, estilos1, estilosBanidos1, contatos1,
                    interesse1);
        } catch (Exception e) {
            fail("Não deveria lançar exceção.");
        }
    }

    @Test
    public void naoDeveCriarAnuncioSemTitulo() {
        titulo1 = "";

        try {
            new Anuncio(titulo1, descricao1, cidade1, bairro1, instrumentos1, estilos1, estilosBanidos1, contatos1,
                    interesse1);
            fail("Deveria lançar exceção.");
        } catch (Exception e) {
        }

        try {
            new Anuncio(null, descricao1, cidade1, bairro1, instrumentos1, estilos1, estilosBanidos1, contatos1,
                    interesse1);
            fail("Deveria lançar exceção.");
        } catch (Exception e) {
        }
    }

    @Test
    public void naoDeveCriarAnuncioSemDescricao() {
        descricao1 = "";

        try {
            new Anuncio(titulo1, descricao1, cidade1, bairro1, instrumentos1, estilos1, estilosBanidos1, contatos1,
                    interesse1);
            fail("Deveria lançar exceção.");
        } catch (Exception e) {
        }

        try {
            new Anuncio(titulo1, null, cidade1, bairro1, instrumentos1, estilos1, estilosBanidos1, contatos1,
                    interesse1);
            fail("Deveria lançar exceção.");
        } catch (Exception e) {
        }
    }

    @Test
    public void naoDeveCriarAnuncioSemCidade() {
        cidade1 = "";

        try {
            new Anuncio(titulo1, descricao1, cidade1, bairro1, instrumentos1, estilos1, estilosBanidos1, contatos1,
                    interesse1);
            fail("Deveria lançar exceção.");
        } catch (Exception e) {
        }

        try {
            new Anuncio(titulo1, descricao1, null, bairro1, instrumentos1, estilos1, estilosBanidos1, contatos1,
                    interesse1);
            fail("Deveria lançar exceção.");
        } catch (Exception e) {
        }
    }

    @Test
    public void naoDeveCriarAnuncioSemBairro() {
        bairro1 = "";

        try {
            new Anuncio(titulo1, descricao1, cidade1, bairro1, instrumentos1, estilos1, estilosBanidos1, contatos1,
                    interesse1);
            fail("Deveria lançar exceção.");
        } catch (Exception e) {
        }

        try {
            new Anuncio(titulo1, descricao1, cidade1, null, instrumentos1, estilos1, estilosBanidos1, contatos1,
                    interesse1);
            fail("Deveria lançar exceção.");
        } catch (Exception e) {
        }
    }

    @Test
    public void naoDeveCriarAnuncioSemInstrumentos() {
        instrumentos1 = "";

        try {
            new Anuncio(titulo1, descricao1, cidade1, bairro1, instrumentos1, estilos1, estilosBanidos1, contatos1,
                    interesse1);
            fail("Deveria lançar exceção.");
        } catch (Exception e) {
        }

        try {
            new Anuncio(titulo1, descricao1, cidade1, bairro1, null, estilos1, estilosBanidos1, contatos1,
                    interesse1);
            fail("Deveria lançar exceção.");
        } catch (Exception e) {
        }
    }

    @Test
    public void deveCriarAnuncioSemEstilos() {
        estilos1 = "";
        estilosBanidos1 = "";

        try {
            new Anuncio(titulo1, descricao1, cidade1, bairro1, instrumentos1, estilos1, estilosBanidos1, contatos1,
                    interesse1);
        } catch (Exception e) {
            fail("Não deveria lançar exceção.");
        }

        try {
            new Anuncio(titulo1, descricao1, cidade1, bairro1, instrumentos1, null, null, contatos1,
                    interesse1);
        } catch (Exception e) {
            fail("Não deveria lançar exceção.");
        }
    }

    @Test
    public void naoDeveCriarAnuncioSemContatos() {
        contatos1 = "";

        try {
            new Anuncio(titulo1, descricao1, cidade1, bairro1, instrumentos1, estilos1, estilosBanidos1, contatos1,
                    interesse1);
            fail("Deveria lançar exceção.");
        } catch (Exception e) {
        }

        try {
            new Anuncio(titulo1, descricao1, cidade1, bairro1, instrumentos1, estilos1, estilosBanidos1, null,
                    interesse1);
            fail("Deveria lançar exceção.");
        } catch (Exception e) {
        }
    }

    @Test
    public void naoDeveCriarAnuncioSemInteresse() {
        interesse1 = "";

        try {
            new Anuncio(titulo1, descricao1, cidade1, bairro1, instrumentos1, estilos1, estilosBanidos1, contatos1,
                    interesse1);
            fail("Deveria lançar exceção.");
        } catch (Exception e) {
        }

        try {
            new Anuncio(titulo1, descricao1, cidade1, bairro1, instrumentos1, estilos1, estilosBanidos1, contatos1,
                    null);
            fail("Deveria lançar exceção.");
        } catch (Exception e) {
        }
    }
}