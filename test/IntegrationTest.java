import models.Anuncio;
import models.dao.GenericDAO;
import org.junit.Test;
import play.db.jpa.Transactional;
import play.test.FakeApplication;
import play.test.WithBrowser;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;

public class IntegrationTest extends WithBrowser {

    @Override
    public FakeApplication provideFakeApplication() {
        return fakeApplication(inMemoryDatabase());
    }

    @Test
    public void deveCarregarPaginaPrincipal() {
        browser.goTo("http://localhost:" + testServer.port());
        assertThat(browser.pageSource()).contains("Gigs Radar");
        assertThat(browser.pageSource()).contains("Gigs Radar - 16 gig(s) formada(s)"); // 16 porque o ApplicationTest é executado antes desse e tem esse
        // efeito colateral (tentar ajeitar
        // isso)
    }

    @Test
    public void deveAdicionarAnuncio() {
        browser.goTo("http://localhost:" + testServer.port());
        assertThat(browser.pageSource()).doesNotContain("Testando pelo código");
        browser.click("#botaoAnunciar");

        browser.fill("#inputTitulo").with("Testando pelo código");
        browser.fill("#inputDescricao").with("Anúncio criado nos testes");
        browser.fill("#inputCidade").with("Campina Grande");
        browser.fill("#inputBairro").with("Bodocongó");
        browser.fill("#inputInstrumentos").with("Gaita, Violão, Saxofone");
        browser.fill("#inputEstilos").with("Blues, Rock, Jazz");
        browser.fill("#inputEstilosBanidos").with("Pagode, Funk");
        browser.fill("#inputContatos").with("Contato dos testes");
        browser.fill("#inputCodigo").with("testando123");
        browser.fill("#inputContatos").with("Contato dos testes");
        browser.fillSelect("#inputContatos1");

        browser.click("#submitNovoAnuncio");
        assertThat(browser.pageSource()).contains("Testando pelo código");
    }

    @Test
    public void deveFinalizarAnuncio() {
        deveAdicionarAnuncio();

        browser.goTo("http://localhost:" + testServer.port());
        assertThat(browser.pageSource()).contains("Testando pelo código");

        browser.click(".finalizarAnuncio");
        browser.fill("#inputFinalizar").with("testando123");
        browser.fillSelect("#inputEncontrou1");
        browser.click("#submitFinalizar26");

        assertThat(browser.pageSource()).doesNotContain("Testando pelo código");
    }

}