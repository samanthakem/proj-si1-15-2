package controllers;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Endereco;
import model.Horario;
import model.HorarioValidador;
import model.caronaModel.Carona;
import model.caronaModel.GerenciadorDeCaronas;
import model.motoristaModel.GerenciadorDeMotoristas;
import model.motoristaModel.Motorista;
import model.notificacaoModel.GerenciadorDeNotificacoes;
import model.notificacaoModel.Notificacao;
import model.notificacaoModel.NotificacaoPedidoCarona;
import model.pessoaModel.GerenciadorDePessoas;
import model.pessoaModel.Pessoa;
import model.sessaoModel.SessaoValidador;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import util.Utils;

import java.io.IOException;
import java.util.Date;
import java.util.Set;

/**
 * Classe referente ao controller de Carona
 * @author Samantha Monteiro
 */
public class CaronaController extends Controller {
	
	private GerenciadorDeCaronas gerenciadorDeCaronas;
    private GerenciadorDeMotoristas gerenciadorDeMotoristas;
    private GerenciadorDePessoas gerenciadorDePessoas;
    private SessaoValidador sessaoValidador;
    private HorarioValidador horarioValidador = new HorarioValidador();
    private GerenciadorDeNotificacoes gerenciadorDeNotificacoes;


    public CaronaController(){
        gerenciadorDeCaronas = GerenciadorDeCaronas.getGerenciador();
        gerenciadorDeMotoristas = GerenciadorDeMotoristas.getGerenciador();
        gerenciadorDePessoas = GerenciadorDePessoas.getGerenciador();
        gerenciadorDeNotificacoes = GerenciadorDeNotificacoes.getGerenciador();
        sessaoValidador = new SessaoValidador();
    }

	/**
     * Recupera uma carona da coleção de caronas
     * @param {String} id 
     * 		O ID da carona
     */
    public Result getCarona(String id) {
        Carona carona = gerenciadorDeCaronas.getCarona(id);
        return ok(Json.toJson(carona));
    }

    /**
     * S
     * @param id
     * @return
     */
    public Result getCaronasMotorista(String id) {
        System.out.print(">>>>>>>>>>>>>>>>>>>>>> motorista: " +id +"\n");
        Motorista motorista = gerenciadorDeMotoristas.getMotorista(id);
        System.out.print(">>>>>>>>>>>>>>>>>>>>>> motorista: " +motorista.getMatricula() +"\n");
        Set<Carona> caronas = gerenciadorDeCaronas.getCaronasDeMotorista(motorista);

        return ok(Json.toJson(caronas));
    }

    /**
     * Get Caronas that matches the neighborhood, the day and the time
     */
    public Result getCaronas(String bairroOrigem, String bairroDestino, String dia, String hora) {
        horarioValidador.validarDia(dia);
        horarioValidador.validarHora(hora);

        Horario horario = new Horario(Horario.Dia.valueOf(dia), hora);

        Set<Carona> caronas = gerenciadorDeCaronas.getCaronas(bairroOrigem, bairroDestino, horario);

        return ok(Json.toJson(caronas));
    }

    /**
     * Adiciona uma carona a coleção de caronas
     * @return Um JSON com as informações da pessoa se foi possível adicionar, caso contrário a explicação em formato JSON.
     */
    public Result addCarona(String matricula) {
    	
    	JsonNode request = request().body().asJson();

        String pessoaString  = request.get("pessoa").toString();
        String enderecoPartida = request.get("pontoInicial").toString();
        String enderecoDestino = request.get("destino").toString();
        String horarioString = request.get("horario").toString();

        ObjectMapper jsonObjectMapper = new ObjectMapper();
        JsonFactory factory = jsonObjectMapper.getFactory();
        Horario horario = new Horario();
        Pessoa pessoa = new Pessoa();
        Endereco partida = new Endereco();
        Endereco destino = new Endereco();
        try {
            pessoa = jsonObjectMapper.readValue(factory.createParser(pessoaString), Pessoa.class);
            horario = jsonObjectMapper.readValue(factory.createParser(horarioString), Horario.class);
            partida = jsonObjectMapper.readValue(factory.createParser(enderecoPartida), Endereco.class);
            destino = jsonObjectMapper.readValue(factory.createParser(enderecoDestino), Endereco.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Motorista motorista = gerenciadorDeMotoristas.getMotorista(pessoa.getMatricula());
    	Carona carona = new Carona(motorista, partida, destino, horario, motorista.getQuantidadeVagasCarro());
        gerenciadorDeCaronas.addCarona(carona);
        System.out.print(">>>>>>>>>>>>>>>>>>>>>> CaronaHash: " +Integer.toString(carona.hashCode()) +"\n");
//        return ok(carona.toJson());
		return ok(Json.toJson(horario));
    }

    /**
     * Adiciona um passageiro a Carona
     * @return Um JSON com as informações da carona
     */
    public Result modificarCarona(String id) {
        JsonNode request = request().body().asJson();

        String idPassageiro  = Utils.getAtributo("passageiro", request);
        String idMotorista = Utils.getAtributo("motorista", request);
        String idCarona = id;

        Pessoa de = gerenciadorDePessoas.getPessoa(idPassageiro);
        Pessoa para = gerenciadorDePessoas.getPessoa(idMotorista);
        Carona carona = gerenciadorDeCaronas.getCarona(idCarona);

        NotificacaoPedidoCarona notificacaoPedido = new NotificacaoPedidoCarona(de, para, new Date().getTime(), Notificacao.ParaTipo.MOTORISTA, carona);
        gerenciadorDeNotificacoes.addNotificacao(notificacaoPedido);

        return ok(Json.toJson(notificacaoPedido));
    }


}
