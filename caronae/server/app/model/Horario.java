package model;

/**
 * @author aline.
 */
public class Horario {

    public enum Dia {
        SEG("Segunda"), TER("Terça"), QUA("Quarta"), QUI("Quinta"), SEX("Sexta"), SAB("Sabado"), DOM("Domingo");

        private String dia;
        Dia(String dia) {
            this.dia = dia;
        }
    }

    public enum Tipo {
        IDA("Ida"), VOLTA("Volta");

        private String tipo;
        Tipo(String tipo) {
            this.tipo = tipo;
        }
    }
    private String hora;

    private Dia diaDaSemana;

    private Tipo tipo;

    /**
     * Construtor padrão
     */
    public Horario() {}

    /**
     * Construtor de Objetos do tipo Notificacao
     * @param dia dia ao qual corresponde o Horário
     * @param hora hora a qual corresponde o Horário
     */
    public Horario(Dia dia, String hora) {
        setDia(dia);
        setHora(hora);
    }

    public Dia getDia() {
        return diaDaSemana;
    }

    public String getHora() {
        return hora;
    }

    public Tipo getTipo() { return tipo; }

    public void setDia(Dia dia) {
        this.diaDaSemana = dia;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public boolean equals(Object objeto){
        if (!(objeto instanceof Horario)) {
            return false;
        }


        Horario segundoHorario = (Horario) objeto;
        return this.getDia().equals(segundoHorario.getDia())
                && this.getHora().equals(segundoHorario.getHora())
                && this.getTipo().equals(segundoHorario.getTipo());
    }

}
