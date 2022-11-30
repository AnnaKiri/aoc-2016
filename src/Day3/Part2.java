package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part2 {
	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day3\\data.txt";
		
		final String[] arr = Files.readString(Path.of(path)).lines().toArray(String[]::new);
		
		int counter = 0;
		for (int i = 0; i < arr.length - 2; i+=3) {
			for (int j = 1; j < 4; j++) {
			    final String regex = "^\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)$";
			    String str = arr[i].replaceAll(regex, "$" + j);
			    final var a = Integer.parseInt(str);
			    str = arr[i + 1].replaceAll(regex, "$" + j);
			    final var b = Integer.parseInt(str);
			    str = arr[i + 2].replaceAll(regex, "$" + j);
			    final var c = Integer.parseInt(str);
			    
			    if (a + b > c && a + c > b && c + b > a) {
			    	counter++;
			    }
			}
		}
		
		System.out.println(counter);
	}
}
