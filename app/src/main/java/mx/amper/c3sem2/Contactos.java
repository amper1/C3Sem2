package mx.amper.c3sem2;

public class Contactos {
    private String nombre;
    private String telefono;
    private String email;
    private String descContacto;

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getDescContacto() {
        return descContacto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescContacto(String descContacto) {
        this.descContacto = descContacto;
    }

    public void Contacto(String nombre, String telefono, String email, String descContacto) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.descContacto = descContacto;
    }
}
