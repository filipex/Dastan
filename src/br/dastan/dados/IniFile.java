
package br.dastan.dados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author Filipe
 */
public class IniFile implements Serializable {

    private static final long serialVersionUID = 1L;
    private final Map<String, Properties> SECTIONS;
    private final String PATH;

    public IniFile(final File file) {
        this.PATH = file.getAbsolutePath();
        this.SECTIONS = new HashMap<String, Properties>();
        this.SECTIONS.put("", new Properties());
        load(file);
    }

    public IniFile(final String path) {
        this(new File(path));
    }

    public void clear() {
        synchronized (SECTIONS) {
            SECTIONS.clear();
        }
    }

    public File getFile() {
        return new File(PATH);
    }

    public String getProperty(final String section,
                              final String property,
                              final String defaultValue) {
        final Properties props = getProperties(section);
        final String result = props.getProperty(property);
        return result != null ? result : defaultValue;
    }

    public void load(final File file) {
        synchronized (SECTIONS) {
            try {
                // ler todas as linhas do arquivo
                String secao = "";
                String linha = null;
                final BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                while ((linha = reader.readLine()) != null) {
                    secao = processLine(secao, new StringBuffer(linha.trim()));
                }
                reader.close();
            } catch (final IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    public void reload() {
        load(new File(PATH));
    }

    public void save() {
        save(new File(PATH));
    }

    public void save(final File file) {
        try {
            final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            writer.write(this.toString(false));
            writer.flush();
            writer.close();
        } catch (final IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void setProperty(final String section,
                            final String property,
                            final String value) {
        final Properties props = getProperties(section);
        props.setProperty(property, value);
    }

    @Override
    public String toString() {
        return toString(true);
    }

    private Properties getProperties(final String section) {
        synchronized (SECTIONS) {
            Properties props = SECTIONS.get(section);
            if (props == null) {
                props = new Properties();
                SECTIONS.put(section, props);
            }
        return props;
        }
    }

    private String processLine(String section, final StringBuffer line) {
      if (line.length() > 0) {
         if (line.charAt(0) == '[') {
            while (line.charAt(0) == '[') {
               line.deleteCharAt(0);
            }
            while (line.charAt(line.length() - 1) == ']') {
               line.deleteCharAt(line.length() - 1);
            }
            section = line.toString();
         } else {
            final String[] chaveValor = line.toString().split("=");
            if (chaveValor.length == 2) {
               getProperties(section).put(chaveValor[0].trim(), // chave
                                          chaveValor[1].trim()); // valor
            }
         }
      }
      return section;
    }

    @SuppressWarnings("unchecked")
    private String toString(final boolean spaces) {
      synchronized (SECTIONS) {
         final StringBuffer buffer = new StringBuffer();
         final List<String> sections = new ArrayList<String>(SECTIONS.keySet());
         Collections.sort(sections);
         String quebra = System.getProperty("line.separator");
         for (final String section : sections) {
            if (buffer.length() > 0) {
               buffer.append(quebra);
            }
            if (section.length() > 0) {
               buffer.append("[" + section + "]" + quebra);
            }
            final Properties props = SECTIONS.get(section);
            final List<String> keys = new ArrayList(props.keySet());
            Collections.sort(keys);
            for (final String key : keys) {
               buffer.append(key + (spaces ? " = " : "=") + props.get(key) + quebra);
            }
         }
         return buffer.toString();
      }
    }    
}