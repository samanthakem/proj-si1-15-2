package model;

import exceptions.ValidacaoErroMensagem;
import exceptions.ValidacaoFieldsException;
import exceptions.ValidacaoParameterErrors;

/**
 * Created by stenio on 4/22/2016.
 */
public class HorarioValidador {
    private static final String DIA = "Dia";
    private static final String HORA = "Hora";
    private static final String HORARIO = "Horário";

    public HorarioValidador() {}

    public void validarDia(String dia) {
        try {
            Horario.Dia.valueOf(dia);
        } catch (Exception e) {
            throw new ValidacaoFieldsException().addTemplateComParametro(
                    ValidacaoErroMensagem.FORMATO_INVALIDO,
                    ValidacaoParameterErrors.OBJETO, DIA);
        }
    }

    public void validarHora(String hora) {
        try { //19:02
            int h = Integer.parseInt(hora.substring(0,2));
            int m = Integer.parseInt(hora.substring(3,5));

            assert 0 <= h && h <= 23;
            assert hora.charAt(2) == ':';
            assert 0 <= m && m <= 59;
        } catch (Exception e) {
            throw new ValidacaoFieldsException().addTemplateComParametro(
                    ValidacaoErroMensagem.FORMATO_INVALIDO,
                    ValidacaoParameterErrors.OBJETO, HORA);
        }
    }
}
