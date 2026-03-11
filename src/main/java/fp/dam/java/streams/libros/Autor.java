package fp.dam.java.streams.libros;

public class Autor {

	private String nombre;
	private String apellidos;

	public Autor(String nombre) {
		this.nombre = nombre;
	}

	public Autor(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public String getNombreApellidos() {
		return nombre + " " + apellidos;
	}
	
	public String getApellidosNombre() {
		return apellidos + ", " + nombre;
	}

	@Override
	public String toString() {
		return getApellidosNombre();
	}

}
