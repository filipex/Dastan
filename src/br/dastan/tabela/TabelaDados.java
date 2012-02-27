
package br.dastan.tabela;

import java.util.ArrayList;

/**
 *
 * @author GarHoa
 */
public class TabelaDados {

    public TabelaDados() { }

    public ArrayList<Object> carregar(br.dastan.persistencia.TipoDados tabela) {
        ArrayList<Object> linha = new ArrayList<Object>();

        linha.add(tabela.getTpBanco());
        linha.add(tabela.getTpJava());

        return linha;
    }
}
