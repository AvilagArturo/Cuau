

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultasPersona{
    private static final String URL = "jdbc:mysql//localhost:3306/cuau?serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "2028199";

    private Connection conexion;
    private PreparedStatement seleccionaTodasLasPersonas;
    private PreparedStatement seleccionaPersonasPorApellido;
    private PreparedStatement insertaNuevaPersona;
    Persona persona = new Persona();


    public ConsultasPersona(){
        try{
            conexion= DriverManager.getConnection(URL, USUARIO, PASSWORD);

            seleccionaTodasLasPersonas = conexion.prepareStatement("SELECT * From Contactos");
            seleccionaPersonasPorApellido = conexion.prepareStatement("SELECT * From Contactos WHERE apellidos = ?");
            insertaNuevaPersona = conexion.prepareStatement("INSERT INTO Contactos"+
            "(nombre, apellidos, email, telefono)"+
            "VALUES (?, ?, ?, ?)");
        }
        catch(SQLException sqlExcep){
            sqlExcep.printStackTrace();
            System.exit(1);
        }
    }

    public List<Persona > obtenerTodasLasPersonas(){
        List<Persona > resultados = null;
        ResultSet conjuntoResultados = null;

        try{

            conjuntoResultados =seleccionaTodasLasPersonas.executeQuery();
            resultados = new ArrayList< Persona >();

            while (conjuntoResultados.next()){
                resultados.add(new Persona(
                    conjuntoResultados.getInt("idContacto"),
                    conjuntoResultados.getString("nombre"),
                    conjuntoResultados.getString("apellidos"),
                    conjuntoResultados.getString("correo"),
                    conjuntoResultados.getString("telefono")));
            }
        }
        catch(SQLException sqlExcep){
            sqlExcep.printStackTrace();
        }
        finally{
            try{
                conjuntoResultados.close();
            }
            catch (SQLException sqlExcep){
                sqlExcep.printStackTrace();
                cerrar();
            }
        }
        return resultados;
    }

    public List< Persona > obtenerPersonasPorApellido(String apellido){
        List< Persona > resultados = null;
        ResultSet conjuntoResultados = null;

        try{
            seleccionaPersonasPorApellido.setString(1,apellido);
            conjuntoResultados= seleccionaPersonasPorApellido.executeQuery();
            resultados = new ArrayList< Persona >();

            while(conjuntoResultados.next()){
                resultados.add(new Persona(
                    conjuntoResultados.getInt("idContacto"),
                    conjuntoResultados.getString("nombre"),
                    conjuntoResultados.getString("apellidos"),
                    conjuntoResultados.getString("correo"),
                    conjuntoResultados.getString("telefono")));
            }
        }
        catch(SQLException sqlExcep){
            sqlExcep.printStackTrace();
        }
        finally{
            try{
                conjuntoResultados.close();
            }
            catch(SQLException sqlExcep){
                sqlExcep.printStackTrace();
                cerrar();
            }
        }
        return resultados;
    }

    public int agregarPersona(String nomb, String apell, String email, String tel){
    int resultado = 0;

    try{
        insertaNuevaPersona.setString(1,nomb);
        insertaNuevaPersona.setString(2,apell);
        insertaNuevaPersona.setString(3,email);
        insertaNuevaPersona.setString(4,tel);

        resultado = insertaNuevaPersona.executeUpdate();
    }
    catch(SQLException sqlExcep){
        sqlExcep.printStackTrace();
        cerrar();
    }
    return resultado;
    
    }

    public void cerrar(){
        try{
            conexion.close();
        }
        catch(SQLException sqlExcep){
            sqlExcep.printStackTrace();
        }
    }
}
