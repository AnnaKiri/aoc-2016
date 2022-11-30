package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part1 {
	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day3\\data.txt";
		
		final String[] arr = Files.readString(Path.of(path)).lines().toArray(String[]::new);
		
		int counter = 0;
		for (String s : arr) {
		    final String regex = "^\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)$";
		    String str = s.replaceAll(regex, "$1");
		    final var a = Integer.parseInt(str);
		    str = s.replaceAll(regex, "$2");
		    final var b = Integer.parseInt(str);
		    str = s.replaceAll(regex, "$3");
		    final var c = Integer.parseInt(str);
		    
		    if (a + b > c && a + c > b && c + b > a) {
		    	counter++;
		    }
		}
		
		System.out.println(counter);
	}
}
