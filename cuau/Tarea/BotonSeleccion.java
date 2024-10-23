//BotonSeleccion.java
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
// Presenta una lista de selección para elegir una entre las varias opciones
// que se presentan
public class BotonSeleccion extends Frame {
Choice Selector;
public BotonSeleccion() {
    init();
}
public void init() {
Selector = new Choice();
Selector.addItem( "Rojo" );
Selector.addItem( "Verde" );
Selector.addItem( "Azul" );
add( Selector );

Panel panDerecha = new Panel();/*se agrega el panel */
panDerecha.setLayout(new GridLayout(2, 1));/*formato al panel */
Label labelDerecha = new Label("programa desarrollado por:");
TextField textBoxDerecha = new TextField("Avila Gonzalez Luis Arturo");
panDerecha.add(labelDerecha);/*se añaden tanto label como texfield al panel */
panDerecha.add(textBoxDerecha);
add(panDerecha, BorderLayout.EAST);/*se dictamina la posicion del panel */

setSize(300, 300);
setVisible(true);
addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent we){
        System.exit(0);
    }
});
}
// Cuando nos llegue el evento de la lista, presentamos en la
// consola un texto indicando cual ha sido el elemento que se
// ha seleccionado en la lista
public boolean action( Event evt,Object obj ) {
if( evt.target instanceof Choice )
{
String color = (String)obj;
System.out.println( "El color elegido es el " + color );
}
return true;
}
public static void main(String[] args)
    {
        BotonSeleccion objBotonSeleccion = new BotonSeleccion();
    }
}
// fin clase BotonSeleccion