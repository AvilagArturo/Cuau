import java.awt.*;
import java.awt.event.*;
public class Suma {
private Frame f;
private Label la, lb, ls, la1;
private TextField ta, tb, ts, tsN;
private Button bsuma, bsalir;
private Panel pan, pac, pas, paE; //agrega panE para la label y textfield
public Suma() {
f = new Frame ("Suma dos numeros");
la = new Label ("Numero A: ");
la1 = new Label("Programa desarrollado por: "); //label para tarea
lb = new Label ("Numero B: ");
ls = new Label ("Resultado: ");
bsuma = new Button ("Sumar");
bsalir = new Button ("Salir");
ta = new TextField (5);
tb = new TextField (5);
tsN = new TextField (5);//text field tarea
ts = new TextField (8);
pan = new Panel();
paE = new Panel();
pac = new Panel();
pas = new Panel();
}
public void AcomodarEnFrame() {
bsuma.addActionListener (new ManejadorBoton());
bsalir.addActionListener (new SalirBoton());
pan.setLayout(new GridLayout(2,2));
pan.add(la);
pan.add(ta);
pan.add(lb);
pan.add(tb);
f.add(pan, BorderLayout.NORTH);
pac.add(ls);
pac.add(ts);
f.add(pac,BorderLayout.CENTER);
pas.add(bsuma);
pas.add(bsalir);
paE.setLayout(new GridLayout(2,2)); /* Grid para formato */
f.add(pas,BorderLayout.SOUTH);
f.setSize(300,300);
f.setVisible(true);
f.add(paE, BorderLayout.WEST);/* Panel de la Izquierda */
paE.add(la1);/* Se agrega los elemntos, tanto label como txbox */
paE.add(tsN);
tsN.setText("Avila Gonzalez Luis Arturo"); /* Se agrega el texto */
}
class ManejadorBoton implements ActionListener {
public void actionPerformed (java.awt.event.ActionEvent actionEvent){
int na, nb, sab;
String res;
na = Integer.parseInt(ta.getText());
nb = Integer.parseInt(tb.getText());
sab = na + nb;
res = Integer.toString(sab);
ts.setText(res);
}
}
class SalirBoton implements ActionListener {
public void actionPerformed(java.awt.event.ActionEvent actionEvent){
System.exit(-1);
}
}
public static void main (String[]args){
Suma guisuma = new Suma();
guisuma.AcomodarEnFrame();
}
} //fin clase Suma