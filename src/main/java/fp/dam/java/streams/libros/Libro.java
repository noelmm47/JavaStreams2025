package fp.dam.java.streams.libros;

public class Libro {

	private String titulo;
	private Autor autor;
	private String genero;
	private float precio;
	private int stock;
	
	public Libro(String titulo, Autor autor, String genero, float precio, int stock) {
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.precio = precio;
		this.stock = stock;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getTitulo() {
		return titulo;
	}

	public Autor getAutor() {
		return autor;
	}
	
	public String getGenero() {
		return genero;
	}

	@Override
	public String toString() {
		return titulo + " (" + genero + ")" + " (" + autor + ")";
	}
	
}
