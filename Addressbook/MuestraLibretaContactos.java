
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.BorderFactory; 
import javax.swing.Box; 
import javax.swing.BoxLayout; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JOptionPane; 
import javax.swing.JPanel; 
import javax.swing.JTextField;

public class MuestraLibretaContactos extends JFrame{
    private Persona entradaActual;
    private ConsultasPersona ConsultasPersona;
    private List< Persona > resultado;
    private int numeroDeEntradas;
    private int indiceEntradaActual;

    private JButton btnNavegar;
    private JLabel lblEmail;
    private JTextField tfEmail;
    private JLabel lblNombre;
    private JTextField tfNombre;
    private JLabel lblId;
    private JTextField tfId;
    private JTextField tfIndice;
    private JLabel lblApellidos;
    private JTextField tfApellidos;
    private JTextField tfMaximo;
    private JButton btnSiguiente;
    private JLabel lblDe;
    private JLabel lblTelefono;
    private JTextField tfTelefono;
    private JButton btnAnterior;
    private JButton btnConsulta;
    private JLabel lblConsulta;
    private JPanel pnlConsulta;
    private JPanel pnlNavegar;
    private JPanel pnlMostrar;
    private JTextField tfConsulta;
    private JButton btnInsertar;

    Persona persona = new Persona();
    ConsultasPersona consultasPersona = new ConsultasPersona();



    public MuestraLibretaContactos(){
        super("Libreta de contactos");
        ConsultasPersona = new ConsultasPersona();

        
        pnlNavegar = new JPanel(); 
        btnAnterior = new JButton(); 
        tfIndice = new JTextField(2); 
        lblDe = new JLabel();
        tfMaximo= new JTextField(2); 
        btnSiguiente = new JButton();
        pnlMostrar = new JPanel(); 
        lblId = new JLabel();
        tfId = new JTextField(10); 
        lblNombre = new JLabel(); 
        tfNombre = new JTextField(10); 
        lblApellidos = new JLabel(); 
        tfApellidos = new JTextField(10); 
        lblEmail = new JLabel();
        tfEmail = new JTextField(10); 
        lblTelefono = new JLabel();
        tfTelefono = new JTextField(10);
        pnlConsulta = new JPanel();
        lblConsulta = new JLabel();
        tfConsulta = new JTextField(10);
        btnConsulta = new JButton();
        btnNavegar = new JButton();
        btnInsertar = new JButton();
    
    
        setLayout(new FlowLayout (FlowLayout.CENTER, 10, 10)); setSize(400, 500);
        setResizable(false);
        pnlNavegar.setLayout(new BoxLayout (pnlNavegar, BoxLayout.X_AXIS));
        btnAnterior.setText("Anterior"); btnAnterior.setEnabled(false);
        btnAnterior.addActionListener(new ActionListener()
            {
                public void actionPerformed (ActionEvent evt){
                    btnAnteriorActionPerformed (evt);
                    }
        }
        );
        pnlNavegar.add(btnAnterior);
        pnlNavegar.add(Box.createHorizontalStrut (10));
        tfIndice.setHorizontalAlignment (JTextField.CENTER); tfIndice.addActionListener(new ActionListener()
            { 
                public void actionPerformed (ActionEvent evt){
                    tfIndiceActionPerformed (evt);
                }
            }
        );

        pnlNavegar.add(tfIndice);
        pnlNavegar.add(Box.createHorizontalStrut (10));
        lblDe.setText("De");
        pnlNavegar.add(lblDe);
        pnlNavegar.add(Box.createHorizontalStrut (10));
        tfMaximo.setHorizontalAlignment (JTextField.CENTER); tfMaximo.setEditable(false);
        pnlNavegar.add(tfMaximo);
        pnlNavegar.add(Box.createHorizontalStrut (10));
        btnSiguiente.setText("Siguiente");
        btnSiguiente.setEnabled(false);
        btnSiguiente.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                btnSiguienteActionPerformed(evt);
            }
        }
        );
        
        pnlNavegar.add(btnSiguiente); add (pnlNavegar);
        pnlMostrar.setLayout(new GridLayout(5, 2, 4, 4));
        lblId.setText("ID Contacto"); 
        pnlMostrar.add(lblId);
        tfId.setEditable(false); 
        pnlMostrar.add(tfId);
        lblNombre.setText("Nombre(s):"); 
        pnlMostrar.add(lblNombre); 
        pnlMostrar.add(tfNombre);
        lblApellidos.setText("Apellidos: ");
        pnlMostrar.add(lblApellidos);
        pnlMostrar.add(tfApellidos);
        lblEmail.setText("Email:");
        pnlMostrar.add(lblEmail);
        pnlMostrar.add(tfEmail);
        lblTelefono.setText("Teléfono:");
        pnlMostrar.add(lblTelefono);
        pnlMostrar.add(tfTelefono);
        add (pnlMostrar);
        pnlConsulta.setLayout(new BoxLayout (pnlConsulta, BoxLayout.X_AXIS));
        pnlConsulta.setBorder (BorderFactory.createTitledBorder("Encuentra un registro por apellido"));
        lblConsulta.setText("Apellido (s)");
        pnlConsulta.add(Box.createHorizontalStrut (5));
        pnlConsulta.add(lblConsulta);
        pnlConsulta.add(Box.createHorizontalStrut (10));
        pnlConsulta.add(tfConsulta);
        pnlConsulta.add(Box.createHorizontalStrut (10));

        
        btnConsulta.setText("Buscar");
        btnConsulta.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                btnConsultaActionPerfmormed(evt);
            }
        }
        );
        pnlConsulta.add(btnConsulta);
        pnlConsulta.add(Box.createHorizontalStrut (5));
        add (pnlConsulta);
        btnNavegar.setText("Navegar por todos los registros"); 
        btnNavegar.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent evt)
            {
            btnNavegarActionPerformed (evt);
            }
        }
        );

        add(btnNavegar);
        
        btnInsertar.setText("Insertar nuevo registro"); 
        btnInsertar.addActionListener(new ActionListener(){
        public void actionPerformed (ActionEvent evt) 
            { 
                btnInsertarActionPerformed (evt);
            }
        }
        );
        add (btnInsertar);
        addWindowListener( new WindowAdapter(){
            public void windowClosing (WindowEvent evt){
                ConsultasPersona.cerrar();
                System.exit(0);
            }
        }
        );
        setVisible(true);


    }

    private void btnAnteriorActionPerformed(ActionEvent evt)
    {
        indiceEntradaActual--;

        if (indiceEntradaActual < 0)
            indiceEntradaActual = numeroDeEntradas - 1;

        tfIndice.setText("" + (indiceEntradaActual + 1));
        tfIndiceActionPerformed(evt);
    }

    // maneja la llamada cuando se da click en btnSiguiente
    private void btnSiguienteActionPerformed(ActionEvent evt)
    {
        indiceEntradaActual++;

        if (indiceEntradaActual >= numeroDeEntradas)
            indiceEntradaActual = 0;

        tfIndice.setText("" + (indiceEntradaActual + 1));
        tfIndiceActionPerformed(evt);
    }

    // maneja la llamada cuando se da click en btnConsulta
    private void btnConsultaActionPerformed(ActionEvent evt)
    {
        resultados = consultasPersona.obtenerPersonasPorApellido(tfConsulta.getText());
        numeroDeEntradas = resultados.size();

        if (numeroDeEntradas != 0)
        {
            indiceEntradaActual = 0;
            entradaActual = resultados.get(indiceEntradaActual);
            tfId.setText("" + entradaActual.getIdDireccion());
            tfNombre.setText(entradaActual.getNombre());
            tfApellidos.setText(entradaActual.getApellidos());
            tfEmail.setText(entradaActual.getEmail());
            tfTelefono.setText(entradaActual.getTelefono());
            tfMaximo.setText("" + numeroDeEntradas);
            tfIndice.setText(""+ (indiceEntradaActual+ 1));
            btnSiguiente.setEnabled(true);
            btnAnterior.setEnabled(true);

        }
        else
            btnNavegarActionPerformed(evt);
    }

    private void tfIndiceActionPerformed(ActionEvent evt)
    {
        indiceEntradaActual = (Integer.parseInt(tfIndice.getText()) - 1);

        if (numeroDeEntradas != 0 && indiceEntradaActual < numeroDeEntradas)
        {
            entradaActual = resultados.get(indiceEntradaActual);
            tfId.setText("" + entradaActual.getIdDireccion());
            tfNombre.setText(entradaActual.getNombre());
            tfApellidos.setText(entradaActual.getApellidos());
            tfEmail.setText(entradaActual.getEmail());
            tfTelefono.setText(entradaActual.getTelefono());
            tfMaximo.setText("" + numeroDeEntradas);
            tfIndice.setText("" + (indiceEntradaActual + 1));
        }
    }

    // maneja la llamada cuando se da click en btnNavegar
    private void btnNavegarActionPerformed(ActionEvent evt)
    {
        try
        {
            resultados = consultasPersona.obtenerTodasLasPersonas();
            numeroDeEntradas = resultados.size();

            if (numeroDeEntradas != 0)
            {
                indiceEntradaActual = 0;
                entradaActual = resultados.get(indiceEntradaActual);
                tfId.setText("" + entradaActual.getIdDireccion());
                tfNombre.setText(entradaActual.getNombre());
                tfApellidos.setText(entradaActual.getApellidos());
                tfEmail.setText(entradaActual.getEmail());
                tfTelefono.setText(entradaActual.getTelefono());
                tfMaximo.setText("" + numeroDeEntradas);
                tfIndice.setText("" + (indiceEntradaActual + 1));
                btnSiguiente.setEnabled(true);
                btnAnterior.setEnabled(true);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    // maneja la llamada cuando se da click en btnInsertar
    private void btnInsertarActionPerformed(ActionEvent evt)
    {
        int resultado = consultasPersona.agregarPersona(tfNombre.getText(),tfApellidos.getText(), tfEmail.getText(), tfTelefono.getText());

        if (resultado == 1)
            JOptionPane.showMessageDialog(this, "¡Persona agregada!","Persona Agregada", JOptionPane.PLAIN_MESSAGE);

        else
            JOptionPane.showMessageDialog(this, "¡Persona NO agregada!","Error", JOptionPane.PLAIN_MESSAGE);

        btnNavegarActionPerformed(evt);
    }

    public static void main(String[] args) {
        new MuestraLibretaContactos();
    }

}// fin de la clase MuestraLibretaContactos



