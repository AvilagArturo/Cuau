import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.applet.Applet;
// Presenta tres barras de desplazamiento para, por ejemplo, seleccionar
// un color en base a sus tres componentes RGB
public class Slider extends Frame {
Scrollbar rojo,verde,azul;
public Slider() {
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
rojo = new Scrollbar( Scrollbar.VERTICAL,0,1,0,255 );
verde = new Scrollbar( Scrollbar.VERTICAL,0,1,0,255 );
azul = new Scrollbar( Scrollbar.VERTICAL,0,1,0,255 );
add( rojo );
add( verde );
add( azul );
addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent we){
        System.exit(0);
    }
});
}
public static void main( String args[] ) {
Slider objSlider = new Slider();
}
} //fin clase Slider