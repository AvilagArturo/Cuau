//ComponentesAWT.java
import java.awt.*;
public class ComponentesAWT extends Frame {
public ComponentesAWT() {
Panel bottomPanel = new Panel();
Panel centerPanel = new Panel();
Panel derecha = new Panel(); /*Panel para datos a la derecha */
MenuBar mb = new MenuBar();
Menu m = new Menu( "Menú" );
m.add( new MenuItem( "Menú Selección 1" ) );
m.add( new CheckboxMenuItem( "Menú Selección 2" ) );
m.add( new MenuItem( "Menú Selección 3" ) );
mb.add( m );
setMenuBar( mb );
// Incoporamos los elementos pequeños en la zona inferior
bottomPanel.add( new TextField( "Campo de Texto" ) );
bottomPanel.add( new Button( "Botón" ) );
bottomPanel.add( new Checkbox( "Casilla Verificación" ) );
Choice c = new Choice();
c.addItem( "Selección Item 1" );
c.addItem( "Selección Item 2" );
c.addItem( "Selección Item 3" );
bottomPanel.add( c );
// En la zona central colocamos los elementos mayores
centerPanel.setLayout( new GridLayout( 1,2 ) );
// En la columna izquierda posicionamos un canvas
centerPanel.add( new MiCanvas() );
// En la zona central colocamos una etiqueta y una zona de texto
Panel p = new Panel();
p.setLayout( new BorderLayout() );
p.add( "North",new Label( "Etiqueta",Label.CENTER ) );
p.add( "Center",new TextArea( "Zona de Texto",5,20 ) );
centerPanel.add( p );
setLayout( new BorderLayout() );
add( "South",bottomPanel );
add( "Center",centerPanel );

derecha.setLayout(new GridLayout(2,1));/*Definen formato a tener */
derecha.add(new Label("Programa desarrollado por:"));/*lablel  */
derecha.add(new TextField("Avila Gonzalez Luis Arturo"));/*textfiel */
add("West",derecha);    /*donde se localizara */

// En la columna derecha colocamos una lista de selección
List l = new List( 3,false );
l.addItem( "Lista item 1");
l.addItem( "Lista item 2");
l.addItem( "Lista item 3");
l.addItem( "Lista item 4");
l.addItem( "Lista item 5");
l.addItem( "Lista item 6");
l.addItem( "Lista item 7");
l.addItem( "Lista item 8");
l.addItem( "Lista item 9");
add( "East",l );
}
public static void main( String args[] ) {
ComponentesAWT window = new ComponentesAWT();
window.setTitle("Los Componentes del AWT");
window.pack();
window.show();
}
}
class MiCanvas extends Canvas {
public void paint( Graphics g ) {
int w = size().width;
int h = size().height;
g.drawRect( 0,0,w-1,h-1 );
g.drawString( "Canvas",
( w-g.getFontMetrics().stringWidth( "Canvas" ) )/2,10 );
g.setFont( new Font( "Helvetica",Font.PLAIN,8 ) );
g.drawLine( 10,10,100,100 );
g.fillRect( 9,9,3,3 );
g.drawString( "(10,10)",13,10 );
g.fillRect( 49,49,3,3);
g.drawString( "(50,50)",53,50 );
g.fillRect( 99,99,3,3);
g.drawString( "(100,100)",103,100 );
}
}// fin clases Componentes AWT