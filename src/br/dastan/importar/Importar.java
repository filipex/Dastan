
package br.dastan.importar;

import br.dastan.DAO.TipoDadosDAO;
import br.dastan.controle.Log;
import br.dastan.dados.IniFile;
import br.dastan.exception.MyIOException;
import br.dastan.persistencia.TipoDados;
import br.dastan.tela.TempoImportacao;
import com.sun.xml.internal.ws.util.StringUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javax.swing.JOptionPane.*;
import static br.dastan.util.MyConstant.FILE_DATA;

/**
 *
 * @author GarHoa
 */
public class Importar {
    private TempoImportacao progresso;
    //private TipoDadosDAO daoTD;
    private String modifDados = "";
    private boolean mConstrutor = false;
    private boolean mGetAndSet = false;
    private boolean mEquals = false;
    private boolean mHashCode = false;
    private boolean verifica = true;
    private boolean abortar = false;
    private static final String EXTENSAO = "java";
    private static final String ENCODING = "ISO-8859-1";
    private static final Pattern pattNomeClass =
            Pattern.compile("CREATE TABLE ([_a-z0-9-]+[_a-z0-9-]+[_a-z0-9-]) \\(",
            Pattern.CASE_INSENSITIVE);
    private static final Pattern pattClass =
            Pattern.compile("[\\W]+[\\W]+[\\w\\d]+[\\w\\d] [\\(\\w\\d\\,]+[\\w\\d\\)]",
            Pattern.CASE_INSENSITIVE);
    private static final Pattern pattAtribClass =
            Pattern.compile("[\\w\\d]+[\\w\\d]",
            Pattern.CASE_INSENSITIVE);    
    private static final Pattern pattTipoAtributoClass =
            Pattern.compile("[^\\w\\d]+[\\w\\d]+[\\(\\w\\d\\,]+[\\w\\d\\)]",
            Pattern.CASE_INSENSITIVE);
    private static final Pattern pattKey = Pattern.compile("KEY", Pattern.CASE_INSENSITIVE);
    private static final Pattern pattReference = Pattern.compile("REFERENCE", Pattern.CASE_INSENSITIVE);
    private static final Pattern pattStop = Pattern.compile("\\;", Pattern.CASE_INSENSITIVE);
    /* Expressão regular seleciona apenas as chaves estrangeiras: (\\([a-z0-9]+[a-z0-9]+[a-z0-9]+[a-z0-9]\\))
     * 
     */

    public Importar(String modifDados, boolean mConstrutor, boolean mGetAndSet, boolean mEquals, boolean mHashCode) {
        this.modifDados = modifDados;
        this.mConstrutor = mConstrutor;
        this.mGetAndSet = mGetAndSet;
        this.mEquals = mEquals;
        this.mHashCode = mHashCode;
    }

    public void importarSQL(String arquivoSQL) {
        BufferedReader br = null;

        try {          
            String nomeClass = "";
            List listAtributos = new ArrayList();
            List listTipoAtributos = new ArrayList();
            br = new BufferedReader (new InputStreamReader(new FileInputStream(arquivoSQL), ENCODING));
            progresso = new TempoImportacao();
            progresso.setProgress(0, br.readLine().length(), 0);

            for (String linha = br.readLine(); linha != null; linha = br.readLine()) {
                Matcher mat = pattNomeClass.matcher(linha);
                if(mat.find()) nomeClass = mat.group().replaceAll("CREATE TABLE", "").replace("(", "").trim();

                mat = pattKey.matcher(linha);
                if(!mat.find()) {
                    mat = pattReference.matcher(linha);
                    if(!mat.find()) {
                        mat = pattClass.matcher(linha);
                        String result = "";
                        if(mat.find()) result = mat.group().trim();

                        mat = pattAtribClass.matcher(result);
                        if(mat.find()) listAtributos.add(mat.group().trim());

                        mat = pattClass.matcher(linha);
                        result = "";
                        if(mat.find()) {
                            //result = mat.group().replaceAll(",", "").trim();
                            result = mat.group().replace(",", ".").trim();
                            result = result.replaceAll(",", "").trim();
                            result = result.replace(".", ",").trim();
                        }
                        
                        mat = pattTipoAtributoClass.matcher(result);
                        if(mat.find()) listTipoAtributos.add(mat.group().trim());                        
                    }
                }

                mat = pattStop.matcher(linha);
                if(mat.find()) {
                    gerarArquivoJava(modifDados, nomeClass, listAtributos, listTipoAtributos);
                    /*if(abortar) {
                        abortarImportacao();
                        break;
                    }*/
                    System.out.println(nomeClass);
                    System.out.println(listAtributos);
                    System.out.println(listTipoAtributos + "\n");
                    nomeClass = "";
                    listAtributos.removeAll(listAtributos);
                    listTipoAtributos.removeAll(listTipoAtributos);
                }
                progresso.setAvanca(1);
            }

            progresso.dispose();
            if(verifica) showMessageDialog(null, "Importação finalizada com sucesso!", "Importar", INFORMATION_MESSAGE);
            if(abortar) abortarImportacao();
        } catch (IOException ioe) {
            verifica = false;
            showMessageDialog(null, "Arquivo não encontrado!", "Importar SQL", ERROR_MESSAGE);
            ioe.printStackTrace();
        } catch (Exception e) {
            verifica = false;
            showMessageDialog(null, "Erro:\n" + e.getMessage(), "Importar SQL", ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            verifica = false;
            try {
                if (br != null) br.close();
            } catch (IOException ex2) {
                showMessageDialog(null, ex2.getMessage(), "Importar SQL", ERROR_MESSAGE);
                ex2.printStackTrace();
            }
        }
    }

    private void gerarArquivoJava(String modifDados, String nomeClass, List atributoClass, List tipoAtributoClass) {
        String arquivo = carregarArquivo(nomeClass);

        try {
            //FileWriter fw = new FileWriter("C://Dastan/" + nomeClass + "." + EXTENSAO, true);

            for(int cont = 0; cont < atributoClass.size(); cont++) {
                arquivo += "\t" + modifDados + " ";                
                arquivo += buscarAtributoBanco(tipoAtributoClass.get(cont).toString()) + " ";
                arquivo += atributoClass.get(cont) + ";\n";
            }

            if(!abortar) {
                if(mConstrutor) arquivo = gerarMetConstrutor(arquivo, nomeClass);
                if(mGetAndSet) arquivo = gerarMetGetAndSet(arquivo, atributoClass, tipoAtributoClass);
                if(mEquals) arquivo = gerarMetEquals(arquivo, nomeClass, atributoClass);
                if(mHashCode) arquivo = gerarMetHashCode(arquivo, atributoClass);
            }

            arquivo += "}";
            if(!abortar) criarArquivoJava(nomeClass, arquivo);
            //fw.write(arquivo);
            //fw.close();
        } catch (Exception e) {
            verifica = false;
            showMessageDialog(null, "Problema ao importar arquivo!\nClasse: " + nomeClass, "Gerar Arquivo Java", ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private String buscarAtributoBanco(String tipoAtributoBanco) throws MyIOException {
        TipoDados tab = new TipoDados();
        File file = new File(FILE_DATA);
        IniFile iniF = new IniFile(file);
        //daoTD = new TipoDadosDAO();

        //tab.setTpBanco(tipoAtributoBanco);
        //tab = daoTD.selecionarTpBanco(tab);

        //if(tab.getTpJava() == null) {
        if(iniF.getProperty("PostgreSQL", tipoAtributoBanco, "").isEmpty()) {
            abortar = true;
            Log log = new Log();
            log.gerarLog(tipoAtributoBanco + " não encontrado no banco de dados.");

            return null;
        } else return tab.getTpJava();
    }

    private String gerarMetConstrutor(String arquivo, String nomeClass) {

        arquivo += "\n\tpublic " + nomeClass + "() { }\n\n";

        return arquivo;
    }

    private String gerarMetGetAndSet(String arquivo, List atributoClass, List tipoAtributoClass) {

        arquivo += "\tpublic String toString() { }\n\n";

        for(int cont = 0; cont < atributoClass.size(); cont++) {
            String aux = atributoClass.get(cont).toString();
            arquivo += "\tpublic " + tipoAtributoClass.get(cont) + " get" + StringUtils.capitalize(aux) + "() {\n";
            arquivo += "\t\treturn " + atributoClass.get(cont) + ";\n";
            arquivo += "\t}\n\n";
            aux = atributoClass.get(cont).toString();
            arquivo += "\tpublic void set" + StringUtils.capitalize(aux) + "(" + tipoAtributoClass.get(cont) + " " + atributoClass.get(cont) + ") {\n";
            arquivo += "\t\tthis." + atributoClass.get(cont) + " = " + atributoClass.get(cont) + ";\n";
            arquivo += "\t}\n\n";
        }

        return arquivo;
    }

    private String gerarMetEquals(String arquivo, String nomeClass, List atributoClass) {

        arquivo += "\tpublic boolean equals(Object obj) {\n";
        arquivo += "\t\tif(obj == null || getClass != obj.getClass()) return false;\n";
        arquivo += "\t\tif(this == obj) return true;\n";
        arquivo += "\t\tfinal " + nomeClass + " other = (" + nomeClass + ") obj;\n";
        arquivo += "\t\tif(" + atributoClass.get(0) + " = other." + atributoClass.get(0) + ") return true;\n";
        arquivo += "\t\telse return false;\n";
        arquivo += "\t}\n\n";

        return arquivo;
    }

    private String gerarMetHashCode(String arquivo, List atributoClass) {

        arquivo += "\tpublic int hashCode() {\n";
        arquivo += "\t\treturn 31 + " + atributoClass.get(0) + ";\n";
        arquivo += "\t}\n";

        return arquivo;
    }

    private String carregarArquivo(String nomeClass) {
        String arquivo = "";

        arquivo += "\n\n/**\n *\n * @author " + System.getProperty("user.name") + " \n */\n";
        arquivo += "public class " + nomeClass + " {\n";
        
        return arquivo;
    }

    private void criarArquivoJava(String nomeClass, String arquivo) {
        try {
            FileWriter fw = new FileWriter("C://Dastan/" + nomeClass + "." + EXTENSAO, true);
            fw.write(arquivo);
            fw.close();
        } catch (Exception e) {
            verifica = false;
            showMessageDialog(null, "Problema ao importar arquivo!\nClasse: " + nomeClass, "Gerar Arquivo Java", ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void abortarImportacao() {
        showMessageDialog(null, "Importação abortada!", "Atenção", WARNING_MESSAGE);
        verifica = false;
    }
}