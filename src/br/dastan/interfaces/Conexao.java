
package br.dastan.interfaces;

import java.util.List;

/**
 *
 * @author GarHoa
 */
public interface Conexao<C> {

    public boolean inserir(C object);
    public boolean excluir(C object);
    public boolean atualizar(C object);
    public List<List<Object>> carregar();
    
}
