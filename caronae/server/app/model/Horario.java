package model;

/**
 * @author aline.
 */
public class Horario {

    public enum Dia {
        SEGUNDA, TERÇA, QUARTA, QUINTA, SEXTA;
    }

    private String idHorario;

    private String hora;

    private Dia diaDaSemana;

    /**
     * Construtor padrão
     */
    public Horario() {}

    /**
     * Construtor de Objetos do tipo Notificacao
     * @param dia dia ao qual corresponde o Horário
     * @param hora hora a qual corresponde o Horário
     * @param idHorario o id do Horário
     */
    public Horario(Dia dia, String hora, String idHorario) {
        setDia(dia);
        setHora(hora);
        setIdHorario(idHorario);
    }

    public Dia getDia() {
        return diaDaSemana;
    }

    public String getHora() {
        return hora;
    }

    public String getIdHorario() {
        return idHorario;
    }

    public void setDia(Dia dia) {
        this.diaDaSemana = dia;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setIdHorario(String idHorario) {
        this.idHorario = idHorario;
    }

}
