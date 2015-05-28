package controllers;

import models.Anuncio;
import models.dao.GenericDAO;
import play.Logger;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.util.Collections;
import java.util.List;

public class Application extends Controller {
    private static final GenericDAO DAO = new GenericDAO();
    private static Form<Anuncio> form = Form.form(Anuncio.class);

    @Transactional
    public static Result index() {
        return anuncios();
    }

    @Transactional
    public static Result anuncios() {
        List<Anuncio> resultado = DAO.findAllByClass(Anuncio.class);
        Collections.sort(resultado);

        return ok(index.render(resultado));
    }

    @Transactional
    public static Result novoAnuncio() {
        Form<Anuncio> formPreenchido = form.bindFromRequest();

        if (formPreenchido.hasErrors()) {
            List<Anuncio> resultado = DAO.findAllByClass(Anuncio.class);
            Collections.sort(resultado);

            return badRequest(index.render(resultado));
        } else {
            Anuncio newAnuncio = formPreenchido.get();
            Logger.debug(formPreenchido.data().toString());

            DAO.persist(newAnuncio);
            DAO.flush();

            return anuncios();
        }
    }

}
