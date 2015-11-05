import java.util.*;
import java.io.*;


public class Palindometer {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase;
			
		while(!(frase = sc.nextLine()).equals("0")){
			int milhas = 0;
			int total = Integer.parseInt(frase);
			
			milhas = palidromo(frase);
			
			total += milhas;
			frase = String.valueOf(total);
			
			//System.out.println(total);
			
			//for(int i = 0, j = frase.length() - 1; i < j;  i++, j--){
			//	if(frase.charAt(j) != frase.charAt(j))milhas += palidromo(frase);;
			//}
		
			System.out.println(milhas);
				
		}
	}
	
	public static int palidromo(String frase){
		int vai_um = 0;
		int milhas = 0;
			
		for(int i = 0, j = frase.length() - 1; i < j;  i++, j--){
				//System.out.println("i :"+ i + " j: "+ j);
				int x = Character.getNumericValue(frase.charAt(i));
				int y = Character.getNumericValue(frase.charAt(j) + vai_um);
				//System.out.println("x :"+ x + " y: "+ y);
				
				int soma = 0;
				if(x >= y){
					soma = x - y;
					vai_um = 0;
				}else{
					soma = 10 - y + x;
					vai_um = 1;
				}
				
				if(i != 0){
					//System.out.println((soma + vai_um)* (Math.pow(10,i)));
					if(i >= j-1)milhas += (soma + vai_um)* (Math.pow(10,i));
					else milhas += soma * (Math.pow(10,i));
				}
				else milhas += soma;
		}
		return milhas;
	}
}