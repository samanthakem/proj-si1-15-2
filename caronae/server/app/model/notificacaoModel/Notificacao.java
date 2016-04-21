package model.notificacaoModel;

import com.fasterxml.jackson.databind.JsonNode;
import model.pessoaModel.Pessoa;
import play.libs.Json;

/**
 * Created by stenio on 4/18/2016.
 */
public class Notificacao {

    public enum ParaTipo {
        MOTORISTA, PASSAGEIRO;
    }

    private String idNotificacao,
            razao;

    private Pessoa de,
            para;

    private long timestamp;

    private ParaTipo paraTipo;

    public Notificacao() {}

    /**
     * Construtor do Objeto Notificacao
     * @param {Pessoa}
     *      de A Pessoa cuja ação gerou a notificação
     * @param {Pessoa}
     *      para A pessoa que deve ser notificada
     * @param {String}
     *      razao A razao que gerou a notificacao
     * @param {Long}
     *      timestamp O timestamp do momento em que a notificacao foi gerada
     */
    public Notificacao(String idNotificacao, Pessoa de, Pessoa para, String razao, long timestamp, ParaTipo paraTipo) {
        setIdNotificacao(idNotificacao);
        setDe(de);
        setPara(para);
        setRazao(razao);
        setTimestamp(timestamp);
        setParaTipo(paraTipo);
    }

    /**
     * Define o atributo de
     * @param {Pessoa}
     *      de A Pessoa cuja ação gerou a notificação
     */
    public void setDe(Pessoa de) {
        this.de = de;
    }

    /**
     * @return {Pessoa} A Pessoa cuja ação gerou a notificação
     */
    public Pessoa getDe() {
        return this.de;
    }

    /**
     * Define o atributo para
     * @param {Pessoa}
     *      para A pessoa que deve ser notificada
     */
    public void setPara(Pessoa para) {
        this.para = para;
    }

    /**
     * @return {Pessoa} A pessoa que deve ser notificada
     */
    public Pessoa getPara() {
        return this.para;
    }

    /**
     * Define o atributo razao
     * @param {String}
     *      razao A razao que gerou a notificacao
     */
    public void setRazao(String razao) {
        this.razao = razao;
    }

    /**
     * @return {String} A razao que gerou a notificacao
     */
    public String getRazao() {
        return this.razao;
    }

    /**
     * Define o atributo idNotificacao
     * @param {String}
     *      idNotificacao O id para a notificação
     */
    public void setIdNotificacao(String idNotificacao) {
        this.idNotificacao = idNotificacao;
    }

    /**
     * @return O id da notificação
     */
    public String getIdNotificacao() {
        return this.idNotificacao;
    }

    /**
     * O momento em que a notificacao foi gerada
     * @param {Long}
     *      timestamp O timestamp do momento em que a notificacao foi gerada
     */
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return {Long} O timestamp do momento em que a notificacao foi gerada
     */
    public long getTimestamp() {
        return this.timestamp;
    }

    /**
     * Define o atributo paraTipo. Notificacao eh pra pessoa do paraTipo.
     * @param {ParaTipo}
     *      paraTipo O novo paraTipo. MOTORISTA / PASSAGEIRO
     */
    public void setParaTipo(ParaTipo paraTipo) {
        this.paraTipo = paraTipo;
    }

    /**
      * @return {ParaTipo}
     *      retorna o paraTipo da pessoa a quem a notificacao se destina.
     */
    public ParaTipo getParaTipo() {
        return this.paraTipo;
    }

    public JsonNode toJson() {
        return Json.toJson(this);
    }
}
