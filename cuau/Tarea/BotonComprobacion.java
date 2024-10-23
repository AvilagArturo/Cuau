import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BotonComprobacion extends Frame
{
    Checkbox relleno;
    public BotonComprobacion (){
        relleno = new Checkbox("Relleno");
        add(relleno);
        setSize(300, 300);
        setVisible(true);
        Panel panDerecha = new Panel();/*se agrega el panel */
        panDerecha.setLayout(new GridLayout(2, 1));/*formato al panel */
        Label labelDerecha = new Label("programa desarrollado por:");
        TextField textBoxDerecha = new TextField("Avila Gonzalez Luis Arturo");
        panDerecha.add(labelDerecha);/*se añaden tanto label como texfield al panel */
        panDerecha.add(textBoxDerecha);
        add(panDerecha, BorderLayout.EAST);/*se dictamina la posicion del panel */
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
    }
    // imprimimos por consola cuando llega el evento
    public boolean action(Event evt, Object obj)
    {
        if(evt.target instanceof Checkbox)
            System.out.println("CheckBox: " + evt.arg.toString());
        return true;
    }

    public static void main(String [] args)
    {
        BotonComprobacion objBotonComprobacion = new BotonComprobacion();
        objBotonComprobacion.action(null, objBotonComprobacion);
    }
}
