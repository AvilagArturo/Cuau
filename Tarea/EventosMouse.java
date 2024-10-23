package eventos;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventosMouse extends JFrame {

    public EventosMouse() {
        JLabel lblSaludo = new JLabel();
        lblSaludo.setBounds(25, 10, 350, 30);

        JLabel lblInstruccion = new JLabel("Ingresa tu nombre");
        lblInstruccion.setBounds(25, 165, 200, 30);

        JTextField campoSaludo = new JTextField(200);
        campoSaludo.setBounds(25, 200, 200, 30);

        JButton boton = new JButton("¡Saludar!");
        boton.setBounds(25, 235, 150, 30);

        MouseListener listener = new MouseListener() {
            /*
             * @Override
             * public void mouseClicked(MouseEvent e) {
             * lblSaludo.setText("mouseClicked");
             * }
             */

            @Override
            public void mousePressed(MouseEvent e) {
                lblSaludo.setText("mousePressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                lblSaludo.setText("mouseReleased");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblSaludo.setText("mouseEntered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblSaludo.setText("mouseExited");
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == campoSaludo) {
                    lblSaludo.setText("MouseClicked dentro del campo saludo");
                }
                if (e.getSource() == boton) {
                    lblSaludo.setText("MouseClicked dentro de boton");
                }
            }
        };

        boton.addMouseListener(listener);
        campoSaludo.addMouseListener(listener);

        add(lblSaludo);
        add(lblInstruccion);
        add(campoSaludo);
        add(boton);

        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]) {
        EventosMouse objEventoMouse = new EventosMouse();
    }
}
