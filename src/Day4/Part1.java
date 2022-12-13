package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Part1 {
	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day4\\data.txt";
		final String [] roomsList = Files.readString(Path.of(path)).lines().toArray(String[]::new);
		
		int sum = 0;
		for (String str : roomsList) {
			final String regex = "^([a-z-]+)(\\d+)\\[(\\w+)\\]$";
			String encryptedName = str.replaceAll(regex, "$1");
			int id = Integer.parseInt(str.replaceAll(regex, "$2"));
			String checksum = str.replaceAll(regex, "$3");

			Map<Character, Integer> map = new HashMap<>();
			for (char c : encryptedName.toCharArray()) {
				if (c == '-') {
					continue;
				}
				
				if (map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
				} else {
					map.put(c, 1);
				}
			}
			
			TreeSet<CharCounting> set = new TreeSet<>();
			for (Map.Entry<Character, Integer> entry : map.entrySet()) {
				set.add(new CharCounting(entry.getKey(), entry.getValue()));
			}
			
			String myChecksum = "";
			for (int i = 0; i < 5; i++) {
				myChecksum = myChecksum + String.valueOf(set.last().getKey());
		        set.remove(set.last());
			}
			
			if (myChecksum.equals(checksum)) {
				sum += id;
			}
		}
		
		System.out.println(sum);
		
	}			
}
