import java.util.*;
import java.io.*;

public class Knitting {

	public static void main (String[] args) {

		Scanner sc = new Scanner(System.in);
		String frase;
		
		while(!(frase = sc.nextLine()).equals("0 0 0")){
			String[] tokens  = frase.split(" ");
			int last = Integer.parseInt(tokens[0]);
			int rows = Integer.parseInt(tokens[1]);
			int pat_length = Integer.parseInt(tokens[2]);

			int[] pattern =  new int[pat_length];
			frase = sc.nextLine();
			
			int cont = last;
			Scanner sc2 = new Scanner(frase);
			
			for(int i = 0; i < pat_length; i++){
				pattern[i] = sc2.nextInt();
			}
			
			for(int i = 0; i < rows-1; i++){
				last = last + pattern[i%pat_length];
				cont += last;
			}
			
			System.out.println(cont);
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