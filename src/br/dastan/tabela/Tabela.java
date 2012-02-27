package br.dastan.tabela;

import br.dastan.persistencia.TipoDados;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.ArrayList;
import static javax.swing.JOptionPane.*;

/**
  * @author GarHoa
  */
public class Tabela extends AbstractTableModel {
	private List<String> colunas;
	private List<List<Object>> linhas;

	public Tabela() {
		colunas = new ArrayList<String>();
		linhas = new ArrayList<List<Object>>();
	}
	
	public Tabela(String[] titulos) {
		colunas = new ArrayList<String>();
		
		for(int cont = 0; cont < titulos.length; cont++) {
			colunas.add(titulos[cont]);
		}
		
		linhas = new ArrayList<List<Object>>();
 	}
	
	public Tabela(List dados, String[] titulos) {
		this();
		
		try {
			for(int cont = 0; cont < titulos.length; cont++) colunas.add(titulos[cont]);
						
			for(int cont = 0; cont < dados.size(); cont++) {
                            ArrayList<Object> linha = new ArrayList<Object>();
                            TabelaDados tb = new TabelaDados();
                            Object obj = new Object();
                            obj = dados.get(cont);

                            if(obj instanceof TipoDados) {
                                TipoDados tipoDados = new TipoDados();
                                tipoDados = (TipoDados) dados.get(cont);

                                linha.addAll(tb.carregar(tipoDados));
                            }
				
                            linhas.add(linha);
			}
                } catch(Exception ex) {
			showMessageDialog(null, "Erro ao carregar dados.\n" + ex.getMessage(), "DTAB01 - Tabela", ERROR_MESSAGE);
                        ex.printStackTrace();
		}
	}
	
	public List<List<Object>> getLinhas() {
		return linhas;
	}
	
	public int getColumnCount() {
		return colunas.size();
	}
	
	public int getRowCount() {
		return linhas.size();
	}
	
	public Object getValueAt(int linha, int coluna) {
		return linhas.get(linha).get(coluna);
	}
	
	public String getColumnName(int indice) {
		return colunas.get(indice);
	}
	
	public boolean isCellEditable(int linha, int coluna) {
		return false;
	}
	
	public Class getColumnClass(int coluna) {
		return getValueAt(0, coluna).getClass();
	}
	
	public void removeRow(int linha) {
		linhas.remove(linha);
	}
	
	public void insertRow(List<Object> linha) {
		linhas.add(linha);
	}
	
	public void clearLines() {
		linhas.clear();
	}
}