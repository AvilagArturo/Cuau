// Creación de objetos JButton.
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
public class MarcoBoton extends JFrame
{
private JButton botonJButtonSimple; // botón con texto solamente
private JButton botonJButtonElegante;
private JTextField campoTextoDerecha; // botón con iconos
// MarcoBoton agrega objetos JButton a JFrame
public MarcoBoton()
{
super( "Prueba de botones" );
setLayout( new FlowLayout() ); // establece el esquema del marco
botonJButtonSimple = new JButton( "Boton simple" ); // botón con texto
add( botonJButtonSimple ); // agrega botonJButtonSimple a JFrame
Icon insecto1 = new ImageIcon( getClass().getResource( "insecto1.gif" ) );
Icon insecto2 = new ImageIcon( getClass().getResource( "insecto.gif" ) );
botonJButtonElegante = new JButton( "Boton elegante", insecto1 ); // establece la imagen
botonJButtonElegante.setRolloverIcon( insecto2 ); // establece la imagen de sustitución
add( botonJButtonElegante ); // agrega botonJButtonElegante a JFrame
// crea nuevo ManejadorBoton para manejar los eventos de botón
ManejadorBoton manejador = new ManejadorBoton();
botonJButtonElegante.addActionListener( manejador );
botonJButtonSimple.addActionListener( manejador );

JPanel panelDerecho = new JPanel();/*se declara el panel derecho */
        panelDerecho.setLayout(new FlowLayout());

        JLabel labelDerecha = new JLabel("Programa desarrollado por:");/*se declara y se agrega la label al panel */
        panelDerecho.add(labelDerecha);

        campoTextoDerecha = new JTextField(10);/*se declara y se agrega el texfield al panel */
        campoTextoDerecha.setText("Avila Gonzalez Luis Arturo");/*texto por defecto */
        panelDerecho.add(campoTextoDerecha);

        add(panelDerecho, BorderLayout.EAST);/*se declara la posicion del panel */
} // fin del constructor de MarcoBoton
// clase interna para manejar eventos de botón
private class ManejadorBoton implements ActionListener
{
// maneja evento de botón
public void actionPerformed( ActionEvent evento )
{
JOptionPane.showMessageDialog( MarcoBoton.this, String.format(
"Usted oprimio: %s", evento.getActionCommand() ) );
} // fin del método actionPerformed
} // fin de la clase interna privada ManejadorBoton
} // fin de la clase MarcoBoton