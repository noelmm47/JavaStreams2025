package fp.dam.java.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import fp.dam.java.streams.libros.Libro;

public class Datos {
	
	/* -----------------------------------------------------------------------------------------------------------------
	 *   Retorna una secuencia con todas las palabras de la lengua Española.
	 *  ----------------------------------------------------------------------------------------------------------------
	 */
	static Stream<String>getPalabras() {
		try {
			Path path = Path.of(BloqueA.class.getResource("/palabras.txt").toURI());
			return Files.lines(path);
		} catch (URISyntaxException | IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/* -----------------------------------------------------------------------------------------------------------------
	 *   Retorna una secuencia con las líneas del cuento "La Biblioteca de Babel" de Jorge Luis Borges.
	 *  ----------------------------------------------------------------------------------------------------------------
	 */
	static Stream<String> getLineas() {
		try {
			Path path = Path.of(BloqueB.class.getResource("/La Biblioteca de Babel.txt").toURI());
			return Files.lines(path);
		} catch (URISyntaxException | IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/* -----------------------------------------------------------------------------------------------------------------
	 *   Retorna una lista de libros almacenada en formato JSON en el fichero "Libros.json"
	 *  ----------------------------------------------------------------------------------------------------------------
	 */
	static List<Libro> getLibros() {
		Gson gson = new Gson();
		return gson.fromJson(
				new BufferedReader(new InputStreamReader(Datos.class.getResourceAsStream("/libros.json"))),
				new TypeToken<LinkedList<Libro>>(){}.getType());
	}
}
