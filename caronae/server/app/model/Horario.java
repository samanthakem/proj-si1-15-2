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

    @Override
    public String toString() {
        return "Horario{" +
                "hora='" + hora + '\'' +
                ", diaDaSemana=" + diaDaSemana +
                '}';
    }

    public void setDia(Dia dia) {
        this.diaDaSemana = dia;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getIdHorario() {
        return getHora() + getDia();
    }

    @Override
    public boolean equals(Object objeto){
        if (!(objeto instanceof Horario)) {
            return false;
        }


        Horario segundoHorario = (Horario) objeto;
        return this.getDia().equals(segundoHorario.getDia())
                && this.getHora().equals(segundoHorario.getHora());
    }

}
