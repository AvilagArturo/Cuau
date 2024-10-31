package addressbook;

public class Persona{
    private int idDireccion;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;

    public Persona(){

    }

    public Persona(int idDireccion, String nombre, String apellido, String correo, String telefono){
        setIdDireccion(idDireccion);
        setNombre(nombre);
        setApellido(apellido);
        setCorreo(correo);
        setTelefono(telefono);
    }

    public void setIdDireccion(int idDireccion){
        this.idDireccion = idDireccion;
    }

    public int getIdDireccion(){
        return idDireccion;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public String getApellido(){
        return apellido;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public String getCorreo(){
        return correo;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public String getTelefono(){
        return telefono;
    }


}
