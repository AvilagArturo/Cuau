import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AreaTexto extends Frame{
    TextArea t1, t2;
    Button boton;
    Panel panSup, panInf;
    public AreaTexto()
    {
        boton = new Button("Aceptar");
        t1 = new TextArea();
        t2 = new TextArea("Prueba de un TextArea", 5, 40);
        t2.setEditable(false);
        panSup = new Panel(new GridLayout(1,2));
        panInf = new Panel();
        panSup.add(t1);
        panSup.add(t2);
        panInf.add(boton);
        add(panSup, BorderLayout.NORTH);
        add(panInf, BorderLayout.SOUTH);
        setSize(500, 300);
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

    public boolean action(Event evt, Object obj){
        if(evt.target instanceof Button)
        {
            if("Aceptar".equals(obj))
            {
                String texto = t1.getText();
                System.out.println(texto);
            }
        }
        return true;
    }

    public static void main(String [] args)
    {
        AreaTexto objAreaTexto = new AreaTexto();
        objAreaTexto.action(null, objAreaTexto);
    }

}