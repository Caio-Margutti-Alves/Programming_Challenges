import java.util.*;
import java.io.*;

public class IsTheNameOfTheProblem {

	public static void main (String[] args) {

		Scanner sc = new Scanner(System.in);
		String frase = sc.nextLine();
		
		while(!frase.equals("END")){
			String message = "";
			String[] frases = frase.split("\"");
			boolean iguais =  false;
			
			//System.out.println(frases.length);
			
			if(frases.length == 3 && frases[1] != null && frases[2] != null){
				if(frases[2].charAt(0) == ' '){
					frases[2] = frases[2].substring(1);
					if (frases[1].equals(frases[2])){
						iguais = true;
						message = frases[2];
					}
				}
			}
			
			if (iguais) System.out.println("Quine(" + message + ")");
			else System.out.println("not a quine");
			
			frase = sc.nextLine();
		}
	}
}