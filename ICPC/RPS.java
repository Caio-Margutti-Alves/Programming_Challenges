import java.util.*;
import java.io.*;

public class RPS{

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase = "";
		String frase2 = "" ;

		while(!(frase = sc.nextLine()).equals("E")){
			
			frase2 = sc.nextLine();
			int count1 = 0, count2 = 0;
			
			for(int i = 0; i < frase.length(); i++){
			
				if(frase.charAt(i) == 'R' && frase2.charAt(i)=='S' ||
					frase.charAt(i) == 'S' && frase2.charAt(i) == 'P' ||
					frase.charAt(i) == 'P' && frase2.charAt(i) == 'R' ){
					count1++;
				}else if(frase2.charAt(i) == 'R' && frase.charAt(i)=='S' ||
					frase2.charAt(i) == 'S' && frase.charAt(i) == 'P' ||
					frase2.charAt(i) == 'P' && frase.charAt(i) == 'R' ){
					count2++;
				}
				
				
			}
			
			System.out.println("P1: " + count1);
			System.out.println("P2: " + count2);
		}
	}
}