import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BotonRadio extends Frame {
    CheckboxGroup radio;
    public BotonRadio()
    {
        Panel panIzquierda = new Panel();
        panIzquierda.setLayout(new GridLayout(3, 1));

        CheckboxGroup radio = new CheckboxGroup();
        panIzquierda.add(new Checkbox("Primero", radio, true));
        panIzquierda.add(new Checkbox("Segundo", radio, false));
        panIzquierda.add(new Checkbox("Tercero", radio, false));

        add(panIzquierda, BorderLayout.WEST);
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

    public static void main(String[] args)
    {
        BotonRadio objBotonRadio = new BotonRadio();
    }
}
