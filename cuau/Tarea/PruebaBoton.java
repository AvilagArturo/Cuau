// Prueba de MarcoBoton.
import javax.swing.JFrame;
public class PruebaBoton
{
public static void main( String args[] )
{
MarcoBoton marcoBoton = new MarcoBoton(); // crea MarcoBoton
marcoBoton.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
marcoBoton.pack(); // establece el tamaño del marco
marcoBoton.setVisible( true ); // muestra el marco
} // fin de main
} // fin de la clase PruebaBoton