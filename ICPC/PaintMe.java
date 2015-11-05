import java.util.*;
import java.io.*;

public class PaintMe {

	public static void main (String[] args) {

		Scanner sc = new Scanner(System.in);
		String frase;
		
		while(!(frase = sc.nextLine()).equals("0 0 0 0 0 0")){
			String[] tokens  = frase.split(" ");
			int num_apt = Integer.parseInt(tokens[0]);
			int width = Integer.parseInt(tokens[1]);
			int lenght = Integer.parseInt(tokens[2]);
			int height = Integer.parseInt(tokens[3]);
			int area = Integer.parseInt(tokens[4]);
			int m = Integer.parseInt(tokens[5]);
			int[][] doors =  new int[m][2];
			
			int walls = (width * height * 2) + (lenght * height * 2);
			int ceiling = width * lenght;
			
			int total_area = (walls + ceiling) * num_apt;
			int total_empty_area = 0;
			
			for(int i = 0; i < m; i++){
				frase = sc.nextLine();
				String[] tokens2 = frase.split(" ");
				total_empty_area += Integer.parseInt(tokens2[0]) * Integer.parseInt(tokens2[1]);
			}
			
			total_empty_area *= num_apt;
			
			total_area = total_area - total_empty_area;
			
			int aux = 0;
			
			if(total_area % area != 0)aux = 1;
			
			total_area = (total_area / area) + aux;
			
			System.out.println(total_area);
			
		}
	}
}


/*

50 8 20 8 350 2
6 3
3 3
50 8 20 8 300 3
6 3
5 3
3 3
0 0 0 0 0 0

*/