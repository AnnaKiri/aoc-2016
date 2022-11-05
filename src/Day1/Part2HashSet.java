package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Part2HashSet {

	public static void main(String[] args) {
		File file = new File(".\\src\\Day1\\data.txt");
		Scanner scan;
		
		try {
			 scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File is not found");
			return;
		}
		
		String str = scan.nextLine();
		scan.close();
		String[] strSep = str.split(", ");	
		
		getCoord(strSep);
	}
	
	public static void getCoord(String[] strSep) {
		int x = 0;
		int y = 0;
		int yaw = 0;
		Set<String> hashSet = new HashSet<>();  // для того, что бы записывать координаты х и у, по которым мы проходимся, и потом сравнивать с новыми, так мы узнаем были ли мы уже на этот месте или нет
		
		int counter = 0;							// счетчик сколько раз был запущен цикл for
		while (true) {								// бесконечный цикл что бы много раз проходиться по массиву в поисках повторных координат
			for (int i=0; i<strSep.length; i++) {
				switch (strSep[i].charAt(0)) {
					case 'R':
						yaw += 90;
						break;
					case 'L':
						yaw -= 90;
						break;
					default:
						System.out.println("Error1!");
						return;
				}
				
				if (yaw >= 360) {
					yaw = yaw - 360;
				}
				
				if (yaw < 0) {
					yaw = yaw + 360;
				}
				
				int step = Integer.parseInt(strSep[i].substring(1, strSep[i].length()));
	
				for (int k=0; k<step; k++) {
					switch (yaw) {
						case 0:
							y += 1;
							break;
						case 90:
							x += 1;
							break;
						case 180:
							y -= 1;
							break;
						case 270:
							x -= 1;
							break;
						default:
							System.out.println("Error2! yaw = " + yaw);
							return;
					}
					
					String coord = x + ";" + y;		// записываем в пеерменную coord координаты
					
					if (hashSet.contains(coord)) {	// узнаем у hashSet есть ли у него такие координаты, если нет, то вернет false
						System.out.println("Result = " + (Math.abs(x) + Math.abs(y)) + "; x = " + x + "; y = " + y + "; counter =" + counter);
						return;
					}
					
					hashSet.add(coord);		// в hashSet записывем координаты
					counter++;				// счетчик увеличивается на 1 с каждым прохождением цикла по координатам
				}
			}
		}
	}
}
