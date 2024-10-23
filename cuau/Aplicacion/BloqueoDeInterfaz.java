import com.sun.jna.Native;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.LRESULT;
import com.sun.jna.platform.win32.WinDef.WPARAM;
import com.sun.jna.platform.win32.WinUser.HWND;
import com.sun.jna.platform.win32.WinUser.MSG;
import com.sun.jna.platform.win32.WinUser.WNDENUMPROC;
import com.sun.jna.platform.win32.WinUser.WindowProc;
import com.sun.jna.platform.win32.WinUser.WM;
import com.sun.jna.platform.win32.WinUser.LPMSG;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BloqueoDeInterfaz {
    private static User32 user32 = User32.INSTANCE;

    // Método para bloquear la estación de trabajo
    public static void bloquearInterfaz() {
        // Bloquear la estación de trabajo
        user32.LockWorkStation(); // Esta línea bloquea la estación de trabajo y muestra la pantalla de bloqueo de Windows
    }

    // Método para iniciar sesión
    public static void login() {
        // Crear un diálogo de login
        JDialog dialog = new JDialog();
        dialog.setTitle("Iniciar Sesión");
        dialog.setModal(true);

        // Crear un panel para ingresar el nombre de usuario y la contraseña
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        // Crear un campo de texto para ingresar el nombre de usuario
        JTextField txtUsuario = new JTextField();
        panel.add(new JLabel("Nombre de usuario:"));
        panel.add(txtUsuario);

        // Crear un campo de texto para ingresar la contraseña
        JPasswordField txtContrasena = new JPasswordField();
        panel.add(new JLabel("Contraseña:"));
        panel.add(txtContrasena);

        // Crear un botón para iniciar sesión
        JButton btnLogin = new JButton("Iniciar Sesión");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Verificar si el nombre de usuario y la contraseña son correctos
                if (txtUsuario.getText().equals("usuario") && new String(txtContrasena.getPassword()).equals("1234")) {
                    // Desbloquear la estación de trabajo
                    user32.UnlockWorkStation(); // Esta línea desbloquea la estación de trabajo
                    dialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(dialog, "Nombre de usuario o contraseña incorrectos");
                }
            }
        });

        // Agregar el panel y el botón al diálogo
        dialog.add(panel, BorderLayout.CENTER);
        dialog.add(btnLogin, BorderLayout.SOUTH);

        // Mostrar el diálogo
        dialog.pack();
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        // Crear la interfaz gráfica
        JFrame frame = new JFrame("Bloqueo de Interfaz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Crear un botón para bloquear la estación de trabajo
        JButton btnBloquear = new JButton("Bloquear");
        btnBloquear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bloquearInterfaz();
                login();
            }
        });

        frame.add(btnBloquear);

        frame.pack();
        frame.setVisible(true);
    }
}