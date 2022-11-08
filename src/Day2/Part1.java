package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {
	public static void main(String[] args) {
		File file = new File(".\\src\\Day2\\data.txt");
		
		Scanner scan;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}
		
		List<String> instructions = new ArrayList<>();
		while (scan.hasNextLine()) {
			instructions.add(scan.nextLine());
		}
		
		scan.close();	
		
		findCode(instructions);
	}
	
	public static void findCode(List<String> instructions) {
		int x = 1;				// на оси координат 5 это х=1, у=1
		int y = 1;
		for (int i = 0; i < instructions.size(); i++) {
			String str = instructions.get(i);
			for (int j = 0; j < str.length(); j++) {
				char symbol = str.charAt(j);
				int newX = x;
				int newY = y;
				switch (symbol) {
				case 'R':
					newX = newX + 1;
					break;
				case 'L':
					newX = newX - 1;
					break;
				case 'U':
					newY = newY + 1;
					break;
				case 'D':
					newY = newY - 1;
					break;
				default:
					break;
				}
				
				if ((newX < 0 || newX > 2) || (newY < 0 || newY > 2)) {
					continue;
				} else {
					x = newX;
					y = newY;
				}
			}
			
			System.out.println(x + "; " + y);

		}
		
	}
}
