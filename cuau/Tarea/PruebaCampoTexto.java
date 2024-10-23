import javax.swing.JFrame;
public class PruebaCampoTexto
{
public static void main( String args[] )
{
CampoTextoMarco campoTextoMarco = new CampoTextoMarco();
campoTextoMarco.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
campoTextoMarco.pack(); // establece el tamaño del marco
campoTextoMarco.setVisible( true ); // muestra el marco
} // fin de main
} // fin de la clase PruebaCampoTexto