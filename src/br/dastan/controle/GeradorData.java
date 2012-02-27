
package br.dastan.controle;

import java.sql.Time;
import java.text.DateFormat;

/**
 *
 * @author GarHoa
 */
public class GeradorData {

    public GeradorData() { }

    public static String getDateFormat() {
        String retorno = "";
        java.util.Date data = new java.util.Date();
        retorno = getDate(data);
        return retorno;
    }

    public static String getDateStr() {
        String retorno = getDateFormat();
        retorno = retorno.replaceAll("/", "");
        return retorno;
    }

    private static String getDate(java.util.Date datautil) {
        String retorno = "";

        if (datautil == null) {
                return retorno;
        }

        retorno = DateFormat.getDateInstance().format(datautil);
        return retorno;
    }

    private static java.util.Date getDateUtil() {
        java.util.Date retorno = new java.util.Date();
        return retorno;
    }

    private static Time getTime() {
        Time retorno = new Time(getDateUtil().getTime());
        return retorno;
    }

    public static String getTimeFormat() {
        String retorno = "";
        retorno = getTime(getTime());
        return retorno;
    }

    public static String getTimeStr() {
        String retorno = getTimeFormat();
        retorno = retorno.replaceAll(":", "");
        return retorno;
    }

    private static String getTime(Time hora) {
        String retorno = "";

        if (hora == null) {
                return retorno;
        }

        retorno = DateFormat.getTimeInstance().format(hora);
        return retorno;
    }
}
