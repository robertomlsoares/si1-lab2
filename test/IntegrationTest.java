import org.junit.Test;
import play.test.FakeApplication;
import play.test.WithBrowser;

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
        assertThat(browser.pageSource()).contains("15 gig(s) formada(s)");
    }
}