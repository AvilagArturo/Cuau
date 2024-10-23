//Lista.java
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.applet.Applet;
// Demostración del uso de listas, generamos una con los nombres de los
// planetas, teniendo siempre 4 visibles e imprimiendo un mensaje
// por consola cuando se produzca una selección, indicando el elemento
// de la lista que se ha seleccionado
public class Lista extends Frame {
    public Lista() {
        init();
    }
public void init() {
setSize( 300, 300 );
setVisible( true );
Panel panDerecha = new Panel();/*se agrega el panel */
panDerecha.setLayout(new GridLayout(2, 1));/*formato al panel */
Label labelDerecha = new Label("programa desarrollado por:");
TextField textBoxDerecha = new TextField("Avila Gonzalez Luis Arturo");
panDerecha.add(labelDerecha);/*se añaden tanto label como texfield al panel */
panDerecha.add(textBoxDerecha);
add(panDerecha, BorderLayout.EAST);/*se dictamina la posicion del panel */
List l = new List( 4,false );
l.addItem( "Mercurio" );
l.addItem( "Venus" );
l.addItem( "Tierra" );
l.addItem( "Marte" );
l.addItem( "Jupiter" );
l.addItem( "Saturno" );
l.addItem( "Neptuno" );
l.addItem( "Urano" );
l.addItem( "Pluton" );
add( l );
addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent we){
        System.exit(0);
    }
});
}
public boolean action( Event evt,Object obj ) {
if( evt.target instanceof List )
System.out.println( "Entrada de la Lista: " + obj );
return( true );
}
public static void main( String[] args ) {
    Lista objLista = new Lista();
}
} // fin clase Lista