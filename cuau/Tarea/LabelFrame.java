import java.awt.FlowLayout; //especifica como se van a ordenar los componentes
import javax.swing.JFrame;// proporciona las características básicas de una ventana
import javax.swing.JLabel; //muestra texto e imagenes
import javax.swing.SwingConstants; //constantes comunes utilizadas con swing
import javax.swing.Icon; //interfaz utilizada para manipular imagenes
import javax.swing.ImageIcon; //carga las imagenes
import javax.swing.JPanel; //panel para agregar componentes
import javax.swing.JTextField; //campo de texto
import java.awt.BorderLayout; //diseño de la ventana

public class LabelFrame extends JFrame {
    private JLabel etiqueta1; //JLabel solo con texto
    private JLabel etiqueta2; //JLabel construida con texto y un icono
    private JLabel etiqueta3; //JLabel con texto adicional e icono
    private JLabel etiqueta4; //JLabel para el panel derecho
    private JTextField textBox; //campo de texto para el panel derecho

    // el constructor de LabelFrame agrega objetos JLabel a JFrame
    public LabelFrame() {
        super("Prueba de JLabel");
        setLayout(new BorderLayout()); //establece el esquema del marco

        // Constructor de JLabel con un argumento String
        etiqueta1 = new JLabel("Etiqueta con texto");
        etiqueta1.setToolTipText("Esta es etiqueta1");
        add(etiqueta1, BorderLayout.NORTH); //agrega etiqueta 1 a JFrame

        // Constructor de JLabel con argumentos de cadena, Icono y alineación
        Icon insecto = new ImageIcon(getClass().getResource("insecto.gif"));
        etiqueta2 = new JLabel("Etiqueta con texto e icono", insecto, SwingConstants.LEFT);
        etiqueta2.setToolTipText("Esta es etiqueta2");
        add(etiqueta2, BorderLayout.CENTER); // agrega etiqueta2 a JFrame

        etiqueta3 = new JLabel(); //Constructor de JLabel sin argumentos
        etiqueta3.setText("Etiqueta con icono y texto en la parte inferior");
        etiqueta3.setIcon(insecto); //agrega icono a JLabel
        etiqueta3.setHorizontalTextPosition(SwingConstants.CENTER);
        etiqueta3.setVerticalTextPosition(SwingConstants.BOTTOM);
        etiqueta3.setToolTipText("Esta es etiqueta3");
        add(etiqueta3, BorderLayout.SOUTH); // agrega etiqueta3 a JFrame

        JPanel panelDerecho = new JPanel();/*se declara el panel derecho */
        panelDerecho.setLayout(new FlowLayout());

        etiqueta4 = new JLabel("Programa desarrollado por:");/*se declara y se agrega la label al panel */
        panelDerecho.add(etiqueta4);

        textBox = new JTextField(20);/*se declara y se agrega el texfield al panel */
        textBox.setText("Avila Gonzalez Luis Arturo");/*texto por defecto */
        panelDerecho.add(textBox);

        add(panelDerecho, BorderLayout.EAST); /*se establece la posicion del panel */

        pack(); // ajusta el tamaño de la ventana
        setVisible(true); // muestra la ventana
    } // fin del constructor de LabelFrame

    public static void main(String[] args) {
        new LabelFrame();
    }
} // fin de la clase LabelFrame