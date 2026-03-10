package fp.dam.java.streams;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BloqueA {
	/**
	 * Para probar los ejercicios de este bloque, usar el método
	 * Datos.getPalabras(), que retorna una secuencia con todas las palabras de la
	 * lengua española.
	 */
	public static void main(String[] args) {
		ejercicio1(Datos.getPalabras());
	}

	/*
	 * 1. Crea un método estático que acepte una secuencia de palabras y muestre en
	 * la consola las palabras que empiecen por 'k', 'ñ', 'w' 'x' o 'y'.
	 */
	public static void ejercicio1(Stream<String> secuencia) {
		String muestra= "kñwxy";
		
		secuencia.filter(s -> muestra.contains(String.valueOf(s.charAt(0))))
		.forEach(System.out::println);
	}

	/*
	 * 2. Crea un método estático que acepte una secuencia de palabras y retorne el
	 * resultado de agrupar las palabras de longitud mayor que 3 que comiencen por
	 * los mismos 3 caracteres.
	 */
	public static void ejercicio2(Stream<String> secuencia) {
		
	}

	/*
	 * 3. Crea un método estático que acepte una secuencia de palabras y una
	 * longitud y muestre en la consola todos los palíndromos de esa longitud. Si la
	 * longitud es menor que 3 se lanzará la excepción IllegalArgumentException.
	 */
	public static void ejercicio3(Stream<String> secuencia, int len) {
		if(len<3)
			throw new IllegalArgumentException();
		
		//Mi idea inicial era hacer un método auxiliar e invocarlo en el filter
		//Pero pudiéndose invocar varios filter, se pueden distribuir los pasos
		secuencia
			.filter(s -> s.length()==len)
		//  .filter(BloqueA::esPalindromo)
			.filter(s -> new StringBuilder(s).reverse().toString().toLowerCase()
							.equals(s.toLowerCase())) //mejor usar las utilidades de Java
			.forEach(System.out::println); //Función consumidora del stream
	}
	
	private static boolean esPalindromo(String s) {
		for(int i=0; i<s.length()/2; i++) {
			if(s.charAt(s.length()-i) != s.charAt(i))
				return false;
		}
		return true;
	}

	/*
	 * 4. Crea un método estático que acepte una secuencia de palabras y retorne por
	 * cada inicial presente en la secuencia, el número de palabras que comienzan
	 * por ella. Como posibles iniciales sólo se considerarán las letras de la 'a' a
	 * la 'z' (minúsculas). Las vocales con tilde se considerarán como vocales sin
	 * tilde.
	 */
	public void ejercicio4() {

	}

	/*
	 * 5. Crea un método estático que acepte una secuencia de palabras y retorne la
	 * longitud de la palabra o palabras mas largas.
	 */
	public int ejercicio5(Stream<String> secuencia) {
		return secuencia
				.mapToInt(String::length) //convertimos los strings en sus longitudes
				.max()
				.orElse(-1);
	}

	/*
	 * 6. Crea un método estático que acepte una secuencia de palabras y retorne el
	 * número de palabras de cada longitud presente en la secuencia.
	 */
	public void ejercicio6() {

	}

	/*
	 * 7. Crea un método estático que acepte una secuencia de palabras y retorne una
	 * LinkedList que contenga las 20 palabras más largas de la secuencia.
	 */
	public LinkedList<String> ejercicio7(Stream<String> secuencia) {
		//CompareStringLength c = new CompareStringLength();
		return (LinkedList<String>) secuencia
				//.sorted(c::compare)
				.sorted(Comparator.comparingInt(String::length).reversed())
				//La ordenacion natural de números va de menor a mayor
				.limit(20)
				.collect(Collectors.toCollection(LinkedList::new));
	}
	/**private class CompareStringLength implements Comparator<String>{
		@Override
		public int compare(String o1, String o2) {
			if(o1.length()>o2.length())
				return 1;
			if(o1.length()<o2.length())
				return -1;
			return 0;
		}
	}*/

	/*
	 * 8. Crea un método estático que acepte una secuencia de palabras y una letra y
	 * retorne el resultado de particionar el conjunto de palabras que comienzan por
	 * esa letra, separando las de longitud par de las de longitud impar.
	 */
	public void ejercicio8() {

	}

	/*
	 * 9. Crea un método estático que acepte una secuencia de palabras y una
	 * longitud mayor que 2, y retorne la lista de palabras de esa longitud que
	 * están contenidas en otras palabras. Se descartarán todos los casos de
	 * palabras contenidas en ellas mismas.
	 */
	public void ejercicio9() {

	}

	/*
	 * 10. Crea un método estático que acepte una secuencia de palabras y una
	 * longitud mayor que 2, y retorne un mapa en el que se asocie cada palabra de
	 * esa longitud con la lista de palabras en las que está contenida. Se
	 * descartarán todos los casos de palabras contenidas en ellas mismas.
	 */
	public void ejercicio10() {

	}

	/*
	 * 11. Crea un método estático que acepte una secuencia de palabras y una
	 * longitud mayor que 2, y retorne un mapa en el que se asocie cada palabra de
	 * esa longitud con la lista de palabras que están contenidas en ella. Se
	 * descartarán todos los casos de palabras contenidas en ellas mismas.
	 */
	public void ejercicio11() {

	}

}
