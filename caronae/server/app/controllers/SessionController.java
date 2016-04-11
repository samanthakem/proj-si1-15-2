package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import model.HttpException;
import model.pessoaModel.Pessoa;
import model.sessaoModel.GerenciadorDeSessao;
import model.sessaoModel.SessaoValidador;
import model.sessaoModel.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Map;


/**
 * Controladora de sessão responsavel por validar o login de um usuario,
 * guardar usuario logado, tempo de permanencia logado na mesma sessao.
 * Created by gustavooliveira on 4/10/16.
 */
public class SessionController extends Controller{
    private SessaoValidador sessaoValidador;
    private GerenciadorDeSessao gerenciadorDeSessao;

    public SessionController() {
        sessaoValidador = new SessaoValidador();
        gerenciadorDeSessao = GerenciadorDeSessao.getGerenciador();
    }

    public Result login(){
        play.mvc.Result result;
//        /Form<User> signUpForm = Form.form(User.class).bindFromRequest();
        JsonNode request = request().body().asJson();

        try {
            Pessoa pessoa = sessaoValidador.validaUsuario(request);

            gerenciadorDeSessao.setPessoa_logada(pessoa);

            result = ok(pessoa.toJson());
        } catch (HttpException e) {
            result = status(e.getStatus(), e.getJSONMessage());
        }

//        return ok("Done");
        return result;
    }

}
