package br.dastan.persistencia;

/*
 * @author GarHoa
 */
public class TipoDados {
    private Integer id;
    private String dBanco;
    private String dJava;

    public TipoDados() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTpBanco() {
        return dBanco;
    }

    public void setTpBanco(String tpBanco) {
        this.dBanco = tpBanco;
    }

    public String getTpJava() {
        return dJava;
    }

    public void setTpJava(String tpJava) {
        this.dJava = tpJava;
    }
}