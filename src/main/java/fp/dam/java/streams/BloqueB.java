package fp.dam.java.streams;

import static java.util.stream.Collectors.averagingInt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BloqueB {
	
	private static Pattern pattern = Pattern.compile("\\p{L}+|\\P{L}+");
	/*
	 * Crea un método estático que acepte una secuencia de cadenas para extraer de cada una de ellas
	 * los elementos que la forman (palabras, uno o más caracteres alfabéticos seguidos,
	 * y no-palabras, todo lo que haya entre cada palabra) y almacenarlos en una lista.
	 * Finalmente se retornará una lista de listas que contenga todas las anteriores.
	 */
	static List<List> ejercicio01(Stream<String> secuencia) {
		return secuencia.map(s -> pattern.matcher(s).results().map(r -> r.group()).collect(Collectors.toCollection(ArrayList::new)))
				.collect(Collectors.toCollection(LinkedList::new));
	}
	
	/*
	 * Crea un método estático que acepte una secuencia de cadenas y retorne el máximo número
	 * de elementos contenidos en una línea.
	 */
	//Mapear la secuencia de líneas a su cantidad de elementos y retornar el máximo
	static long ejercicio02(Stream<String> secuencia) {
		return secuencia
				.mapToLong(s -> pattern.matcher(s).results()
											.map(r->r.group()).count())
				.max()
				.orElse(-1);
	}
	
	/*
	 * Lo mismo que en el ejercicio anterior, pero aceptando una lista como la que retorna el metodo
	 * creado en el ejercicio 1.
	 */
	
	static long ejercicio03(List<List<String>> lista) {
		return 0;
	}
	
	
	/*
	 * Crea un método estático que acepte una lista como la que retorna el ejercicio 1 y retorne una
	 * lista de cadenas que contenga las palabras y no-palabras en orden de aparición.
	 */
	
	static List<String> ejercicio04(List<List<String>> lista) {
		return null;
	}
	
	
	/*
	 * Crea un método estático que acepte una secuencia de cadenas y retorne una lista de cadenas
	 * que contenga las palabras y no-palabras en orden de aparición.
	 */
	
	static List<String> ejercicio05(Stream<String> secuencia) {
		return secuencia
				.flatMap(s -> Arrays.stream(s.split("\\p{L}+|\\P{L}+")))
				.toList();
	}
	
	/*
	 * Crea un método estático que acepte una secuencia de cadenas y retorne el conjunto 
	 * de palabras que se repiten.
	 */
	
	static void ejercicio06(Stream<String> secuencia) {
		secuencia
				.map(s -> pattern.matcher(s).results()
											.map(r -> r.group())) //Importante para mapear de MatchResult a String
				.
	}
	
	
	/*
	 * Crea un método estático que acepte una secuencia de cadenas y retorne la longitud media.
	 */
	
	static double ejercicio07(Stream<String> secuencia) {
		return secuencia.collect(averagingInt(String::length));
	}
	
	/*
	 * Crea un método estático que acepte una secuencia de cadenas y retorne un mapa que asocie
	 * longitudes de palabra con el número de palabras de dicha longitud.
	 * Solo se tendrán en cuenta las diferentes longitudes de las palabras contenidas en la secuencia.
	 */
	
	static Map<Integer, Long> ejercicio08(Stream<String> secuencia) {
		return secuencia
				.collect(Collectors.groupingBy(String::length, Collectors.counting()));
	}
	
	/*
	 * Crea un método estático que acepte una secuencia de cadenas y retorne el total de palabras
	 * en la secuencia sin contar las repetidas.
	 */
	static long ejercicio09(Stream<String> secuencia) {
		return secuencia
				.mapToLong(s -> pattern.matcher(s).results().map(r->r.group()).distinct().count())
				.reduce((l1,l2) -> l1+l2 )
				.orElse(-1);
	}
	
	
	/*
	 * Crea un método estático que acepte una secuencia de cadenas y retorne el total de vocales
	 * y consonantes de la secuencia.
	 */
	
	static Map<Boolean, Long> ejercicio10(Stream<String> secuencia) {
		return null;
	}
	
	
	/*
	 * Crea un método estático que acepte una secuencia de cadenas y una longitud l, y retorne
	 * todas las subcadenas longitud l de cada palabra presentes en la secuencia cuya longitud
	 * sea mayor que l.
	 */
	
	static List<String> ejercicio11(Stream<String> secuencia, int l) {
		return null;
	}
	
}


