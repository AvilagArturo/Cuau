import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.border.Border;
/*dos tipos de eventos
 * EventSourcer -El que resive el evento. -Pide dos cosas, evento y objeto.
 * 
*/
public class OperArimetic 
{
    private Frame f;
    private Label lblInstruccion, lblNum1, lblNum2, lblResult;
    private TextField tfNum1, tfNum2, tfResult;
    private Button btnSuma, btnSalir, btnMulti, btnDiv, btnRest;
    private Panel panNorte, panCentro, panSur, panEst;
    
    public OperArimetic()
    {
        f = new Frame("Suma de dos numeros");
        lblInstruccion = new Label("Ingrese 2 numeros enteros en los cuadros de texto" +
        "de click en calcular");
        lblNum1 = new Label("Ingrese el primer numero: ");
        lblNum2 = new Label("Ingrese el segundo numero: ");
        lblResult = new Label("El resultado es: ");

        tfNum1 = new TextField(5);
        tfNum2 = new TextField(5);
        tfResult = new TextField (8);

        btnSuma = new Button("Sumar");
        btnDiv = new Button("Division");
        btnMulti = new Button("Multiplicacion");
        btnRest = new Button("Restar");
        btnSalir = new Button("Salir");

        panNorte = new Panel();
        panCentro = new Panel();
        panEst = new Panel();
        panSur = new Panel();
    }
    
    public void acomodarComponentes()
    {
        panNorte.setLayout(new FlowLayout());
        panNorte.add(lblInstruccion);

        panCentro.setLayout(new GridLayout(3, 2));
        panCentro.add(lblNum1);
        panCentro.add(tfNum1);
        panCentro.add(lblNum2);
        panCentro.add(tfNum2);
        panCentro.add(lblResult);
        panCentro.add(tfResult);

        panEst.setLayout(new GridLayout(4,1));
        panEst.add(btnSuma);
        panEst.add(btnRest);
        panEst.add(btnMulti);
        panEst.add(btnDiv);

        panSur.add(btnSalir);

        f.add(panNorte,BorderLayout.NORTH);
        f.add(panCentro, BorderLayout.CENTER);
        f.add(panEst, BorderLayout.EAST);
        f.add(panSur, BorderLayout.SOUTH);

        f.setSize(500, 250);
        f.setVisible(true);

        btnSuma.addActionListener(new ManejadorBtnSumar());
        btnRest.addActionListener(new ManejadorBtnRestar());
        btnMulti.addActionListener(new ManejadorBtnMulti());
        btnDiv.addActionListener(new ManejadorBtnDiv());
        btnSalir.addActionListener(new ManejadorBtnSalir());
    }
    
    
    public static void main(String[] args)
    {
        OperArimetic objVentana = new OperArimetic();
        objVentana.acomodarComponentes();
    }

    class ManejadorBtnSumar implements ActionListener{
        public void actionPerformed(java.awt.event.ActionEvent actionEvent){
            try {
                int num1 = Integer.parseInt(tfNum1.getText());
                int num2 = Integer.parseInt(tfNum2.getText());
                int res1 = num1 + num2;
                tfResult.setText(String.valueOf(res1));
            } catch (NumberFormatException e) {
                tfResult.setText("No valido");
            }
        }
        
    }
    class ManejadorBtnRestar implements ActionListener{
        public void actionPerformed(java.awt.event.ActionEvent actionEvent){
            try {
                int num1 = Integer.parseInt(tfNum1.getText());
                int num2 = Integer.parseInt(tfNum2.getText());
                int res1 = num1 - num2;
                tfResult.setText(String.valueOf(res1));
            } catch (NumberFormatException e) {
                tfResult.setText("No valido");
            }

        }
    }
    class ManejadorBtnMulti implements ActionListener{
        public void actionPerformed(java.awt.event.ActionEvent actionEvent){
            try {
                int num1 = Integer.parseInt(tfNum1.getText());
                int num2 = Integer.parseInt(tfNum2.getText());
                int res1 = num1 * num2;
                tfResult.setText(String.valueOf(res1));
            } catch (NumberFormatException e) {
                tfResult.setText("No valido");
            }   
        }
    }
    class ManejadorBtnDiv implements ActionListener{
        public void actionPerformed(java.awt.event.ActionEvent actionEvent){
            try {
                double num1 = Double.parseDouble(tfNum1.getText());
                double num2 = Double.parseDouble(tfNum2.getText());
                double res1 = num1 / num2;
                tfResult.setText(String.valueOf(res1));
            } catch (NumberFormatException e) {
                tfResult.setText("No valido");
            }
        }
    }
    class ManejadorBtnSalir implements ActionListener{
        public void actionPerformed(java.awt.event.ActionEvent actionEvent){
            System.exit(1);
        }
    }
}