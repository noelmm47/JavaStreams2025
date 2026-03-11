package fp.dam.java.streams;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import fp.dam.java.streams.libros.Autor;
import fp.dam.java.streams.libros.Libro;

public class Ejemplos {
	static List<Libro> libros = Datos.getLibros();
	/* Almacenar en un conjunto el nombre de los autores sin repetir
	 * (crear al menos dos stream pipelines distintos) y mostrarlo por consola
	 */
	public static void autoresSinRepetir() {
		Set<String> autores;
		autores= libros.stream()
				.map(libro -> libro.getAutor().getNombre())
				.distinct()
				.collect(Collectors.toSet());
		
		autores= libros.stream()
				.map(Libro::getAutor)
				.map(Autor::getNombre)
				.distinct()
				.collect(Collectors.toCollection(TreeSet::new));
	}

}
