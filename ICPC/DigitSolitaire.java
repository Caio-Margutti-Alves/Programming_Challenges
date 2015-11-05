import java.util.*;
import java.io.*;

public class DigitSolitaire {

	public static void main (String[] args) {

		Scanner sc = new Scanner(System.in);
		int frase;
		
		while((frase = sc.nextInt()) != 0){
			//System.out.println(frase);
			String frase_aux = String.valueOf(frase);
			
			while(frase_aux.length()!=1 ){
				int resp = 1;
				if(frase_aux.equals(""))frase_aux = String.valueOf(frase);
				System.out.print(frase_aux + " ");
				for(int cont = 0; cont < frase_aux.length(); cont++){
					resp *= Character.getNumericValue(frase_aux.charAt(cont));
				}
				frase_aux = String.valueOf(resp);
			}
			System.out.print(frase_aux);
			System.out.println();
		}
	}
}