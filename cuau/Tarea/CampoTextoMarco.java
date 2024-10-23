import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class CampoTextoMarco extends JFrame {
    private JTextField campoTexto1;
    private JTextField campoTexto2;
    private JTextField campoTexto3;
    private JPasswordField campoContrasenia;
    private JTextField campoTextoDerecha;

    public CampoTextoMarco() {
        super("Prueba de JTextField y JPasswordField");
        setLayout(new BorderLayout());

        // Panel izquierdo
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new FlowLayout());

        campoTexto1 = new JTextField(10);
        panelIzquierdo.add(campoTexto1);

        campoTexto2 = new JTextField("Escribe aqui el texto");
        panelIzquierdo.add(campoTexto2);

        campoTexto3 = new JTextField("Campo de texto no editable", 21);
        campoTexto3.setEditable(false);
        panelIzquierdo.add(campoTexto3);

        campoContrasenia = new JPasswordField("Texto oculto");
        panelIzquierdo.add(campoContrasenia);

        add(panelIzquierdo, BorderLayout.CENTER);

        // Panel derecho
        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new FlowLayout());

        JLabel labelDerecha = new JLabel("Programa desarrollado por:");/*se declara la label y se coloca en el panel */
        panelDerecho.add(labelDerecha);

        campoTextoDerecha = new JTextField(10);/*se declara el texfield y se coloca en el panel */
        campoTextoDerecha.setText("Avila Gonzalez Luis Arturo");/*se le da un texto por defecto */
        panelDerecho.add(campoTextoDerecha);

        add(panelDerecho, BorderLayout.EAST);/*se establece la posicion del panel */

        ManejadorCampoTexto manejador = new ManejadorCampoTexto();
        campoTexto1.addActionListener(manejador);
        campoTexto2.addActionListener(manejador);
        campoTexto3.addActionListener(manejador);
        campoContrasenia.addActionListener(manejador);
        campoTextoDerecha.addActionListener(manejador);
    }

    private class ManejadorCampoTexto implements ActionListener {
        public void actionPerformed(ActionEvent evento) {
            String cadena = "";

            if (evento.getSource() == campoTexto1)
                cadena = String.format("campoTexto1: %s", evento.getActionCommand());

            else if (evento.getSource() == campoTexto2)
                cadena = String.format("campoTexto2: %s", evento.getActionCommand());

            else if (evento.getSource() == campoTexto3)
                cadena = String.format("campoTexto3: %s", evento.getActionCommand());

            else if (evento.getSource() == campoContrasenia)
                cadena = String.format("campoContrasenia: %s", new String(campoContrasenia.getPassword()));

            else if (evento.getSource() == campoTextoDerecha)
                cadena = String.format("campoTextoDerecha: %s", evento.getActionCommand());

            JOptionPane.showMessageDialog(null, cadena);
        }
    }
}