package fp.dam.java.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BloqueA {
	/**
	 * Para probar los ejercicios de este bloque, usar el método
	 * Datos.getPalabras(), que retorna una secuencia con todas las palabras de la
	 * lengua española.
	 */
	private static Pattern pattern = Pattern.compile("\\p{L}+|\\P{L}+");
	public static void main(String[] args) {
		//ejercicio1(Datos.getPalabras());
		/*ejercicio2(Datos.getPalabras())
				.forEach((k,v) -> {
					System.out.printf("Secuencia de clave %s\n",k);
					for(String s: v) {
						System.out.println(s);
					}
					System.out.println();
				});*/
		/*ejercicio4(Datos.getPalabras())
			.forEach((k,v) -> {
				System.out.printf("%s: %d\n", k, v);
			});*/
		
		//ejercicio6(Datos.getPalabras())
			//.forEach((k,v) -> System.out.printf("%d: %d\n", k,v));
		
		ejercicio9(Datos.getPalabras(), 3)
		.forEach(System.out::println);
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
	public static Map<Object, Set<String>> ejercicio2(Stream<String> secuencia) {
		return secuencia
		.filter(s-> s.length()>3) //Simplemente no se puede invocar String::length
		.collect(Collectors.groupingBy(s->s.substring(0, 3), Collectors.toSet())); //grouping by agrupa elementos según el valor retornado por la función
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
	public static Map<String, Long> ejercicio4(Stream<String> secuencia) {
		return secuencia
				.collect(Collectors.groupingBy(s -> s
											.toLowerCase()
											.substring(0,1)
											.transform(s2 ->  {
														switch(s2) {
															case "á": return "a";
															case "é": return "e";
															case "í": return "i";
															case "ó": return "o";
															case "ú": return "u";
															default: return s2;
														}
													}
											),Collectors.counting()));
	}

	/*
	 * 5. Crea un método estático que acepte una secuencia de palabras y retorne la
	 * longitud de la palabra o palabras mas largas.
	 */
	public /*int*/ List<String> ejercicio5(Stream<String> secuencia) {
		/*return secuencia
				.mapToInt(String::length) //convertimos los strings en sus longitudes
				.max()
				.orElse(-1);*/
		
		return secuencia
				.flatMap(s -> Arrays.stream(s.split("\\p{L}+|\\P{L}")))
				.toList();
	}

	/*
	 * 6. Crea un método estático que acepte una secuencia de palabras y retorne el
	 * número de palabras de cada longitud presente en la secuencia.
	 */
	public static Map<Integer, Long> ejercicio6(Stream<String> secuencia) {
		return secuencia
				.collect(Collectors.groupingBy(String::length, Collectors.counting()));
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
	public static void ejercicio8(Stream<String> secuencia, char letra) {
		secuencia
		.filter(s -> s.charAt(0)==letra)
		.collect(Collectors.partitioningBy(s -> s.length() % 2 == 2))
		.forEach((k, v) -> System.out.println(v)); 
		//¿Por qué no me deja hacer String::length ? 
		//Igual es porque solo se puede cuando es lo único dentro de los paréntesis
	}

	/*
	 * 9. Crea un método estático que acepte una secuencia de palabras y una
	 * longitud mayor que 2, y retorne la lista de palabras de esa longitud que
	 * están contenidas en otras palabras. Se descartarán todos los casos de
	 * palabras contenidas en ellas mismas.
	 */
	public static List<String> ejercicio9(Stream<String> secuencia, int len) {
		if(len<3)
			throw new IllegalArgumentException();
		List<String> palabras= secuencia.toList();
		return palabras.stream()
				.filter(s -> s.length() == len)
				.filter(s -> palabras.stream()
									 .anyMatch(sup -> !sup.equals(s) && sup.contains(s)))
				.toList();
	}

	/*
	 * 10. Crea un método estático que acepte una secuencia de palabras y una
	 * longitud mayor que 2, y retorne un mapa en el que se asocie cada palabra de
	 * esa longitud con la lista de palabras en las que está contenida. Se
	 * descartarán todos los casos de palabras contenidas en ellas mismas.
	 */
	public static Map<Object, List<String>> ejercicio10(Stream<String> secuencia, int len) {
		if(len < 3)
			throw new IllegalArgumentException();
		
		List<String> lista = secuencia
							.toList();
		return lista.stream()
				.filter(s -> s.length()==len)
				.collect(Collectors.groupingBy(sub -> lista.stream()
								.anyMatch(sup -> !sup.equals(sub) && sup.contains(sub))));
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
