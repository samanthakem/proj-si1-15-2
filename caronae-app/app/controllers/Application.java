package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result login() {
        return ok(login.render("Teste"));
    }

    public Result signUp() {
        return ok(cadastroPessoal.render("Teste"));
    }
}
