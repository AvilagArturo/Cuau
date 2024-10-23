import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperArimetic
{
    private Frame f;
    private Label lblInstruccion, lblNum1, lblNum2, lblResult;
    private TextField tfNum1, tfNum2, tfResult;
    private Button btnCalcular, btnSalir;
    private Panel panNorte, panCentro, panSur;
    
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

        btnCalcular = new Button("Calclar");
        btnSalir = new Button("Salir");

        panNorte = new Panel();
        panCentro = new Panel();
        panSur = new Panel();

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularSuma();
            }
        });
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
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

        panSur.add(btnCalcular);
        panSur.add(btnSalir);

        f.add(panNorte,BorderLayout.NORTH);
        f.add(panCentro, BorderLayout.CENTER);
        f.add(panSur, BorderLayout.SOUTH);

        f.setSize(300, 250);
        f.setVisible(true);
    }

    public void calcularSuma(){
        try {
            int num1 = Integer.parseInt(tfNum1.getText());
            int num2 = Integer.parseInt(tfNum2.getText());
            int res1 = num1 + num2;
            tfResult.setText(String.valueOf(res1));
        } catch (NumberFormatException e) {
            tfResult.setText("No valido");
        }
    }
    
    
    
    public static void main(String[] args)
    {
        OperArimetic objVentana = new OperArimetic();
        objVentana.acomodarComponentes();
    }
}