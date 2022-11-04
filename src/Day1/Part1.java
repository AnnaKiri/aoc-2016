package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {
	public static void main(String[] args) {
		File file = new File(".\\src\\Day1\\data.txt");
		Scanner scan;
		
		try {
			 scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File is not found");
			return;
		}
		
		String str = scan.nextLine();		// считали данные из файла одной строкой, записали в переменную str
		scan.close();
		String[] strSep = str.split(", ");		// сплитим строку str по ", " и записываем разделенные значения в массив strSep
		
		getCoord(strSep);						// ызвали метод getCoord на массиве strSep
		
	}

	public static void getCoord(String[] strSep) {
		int x = 0;
		int y = 0;
		int yaw = 0;								// yaw - направление курса (север, юг, запад, восток)
		for (int i=0; i<strSep.length; i++) {		// проходимся по каждому элементу массива strSep
			switch (strSep[i].charAt(0)) {			// в массиве strSep под индексом i лежит например L25, и мы берем элемент под индексом 0 из L25, то есть L и преобразовывем его в char
				case 'R':							// в случае если в строке 32 мы получили R
					yaw += 90;						// поворачиваем на запад на 90 градусов
					break;
				case 'L':							// в случае если в строке 32 мы получили L
					yaw -= 90;						// поворачиваем на восток на 90 градусов, т.е. -90
					break;
				default:							// в случае если в строке 32 мы не получили ни R ни L
					System.out.println("Error1!");
					return;
			}
			
			if (yaw >= 360) {				// если в ходе чтения массива yaw становится больше 360, значит мы сделали круг по сторонам света вправо
				yaw = yaw - 360;			// нужно держать yaw в диапазоне 0...359
			}
			
			if (yaw < 0) {					// если в ходе чтения массива yaw становится меньше 0, повернули влево и это отрицательное значение градусов
				yaw = yaw + 360;			// а нам нужно положительное
			}
			
			int step = Integer.parseInt(strSep[i].substring(1, strSep[i].length()));  // substring возвращает из строки значения от int beginIndex (в нашем случае элемент под индексом 1 = цифра следующая после L или R) до int endIndex (конец элемента i) не вкючительно, что получили преобразовываем в int, получили количество шагов в указанном направлении

			switch (yaw) {					// выше определили yaw
				case 0:						// смотрим на север
					y += step;				// прибавляем колисетво шагов
					break;
				case 90:					// смотрим на восток
					x += step;				// прибавляем колисетво шагов
					break;
				case 180:					// смотрим на юг
					y -= step;				// если рассмотреть ось координат, то что бы идти на юг нужно отрицательное значение у
					break;
				case 270:					// смотрим на запад
					x -= step;				// если рассмотреть ось координат, то что бы идти на запад нужно отрицательное значение х
					break;
				default:
					System.out.println("Error2! yaw = " + yaw);
					return;
			}
		}
		
		System.out.println("Result = " + (Math.abs(x) + Math.abs(y)) + "; x = " + x + "; y = " + y);	// Math.abs() возвращает положительное значение
		// Result - общее количество шагов по оси х и у, х - количество шагов по оси х, у - количество шагов по оси у
	}
}
