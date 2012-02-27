
package br.dastan.controle;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

/**
 *
 * @author GarHoa
 */
public class Controles {

    public Controles() { }

    public boolean getTextField(JPanel panel) {
        boolean controlador = false;

        for(int cont = 0; cont < panel.getComponentCount(); cont++) {
            Component comp = panel.getComponent(cont);

            if(comp instanceof JTextField) {
                JTextField tf = (JTextField) comp;
                if(tf.getText().equals("")) controlador = true;
            }

            if(comp instanceof JFormattedTextField) {
                JFormattedTextField ft = (JFormattedTextField) comp;
                if(ft.getText().equals("")) controlador = true;
            }

            if(controlador) break;
        }

        return controlador;
    }

    public String getRadioButton(JPanel panel) {
        String tipo = "";

        for(int cont = 0; cont < panel.getComponentCount(); cont++) {
            Component comp = panel.getComponent(cont);

            if(comp instanceof JRadioButton) {
                JRadioButton rb = (JRadioButton) comp;
                if(rb.isSelected()) tipo = rb.getText();
            }
        }

        return tipo;
    }

    public void setCheckBox(JPanel panel) {

        for(int cont = 0; cont < panel.getComponentCount(); cont++) {
            Component comp = panel.getComponent(cont);

            if(comp instanceof JCheckBox) {
                JCheckBox cb = (JCheckBox) comp;
                cb.setSelected(true);
            }
        }

    }
}
