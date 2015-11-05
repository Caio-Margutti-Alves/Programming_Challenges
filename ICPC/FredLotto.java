import java.util.*;
import java.io.*;

public class FredLotto {

	public static void main (String[] args) {

		Scanner sc = new Scanner(System.in);
		int frase;
		
		while((frase = sc.nextInt()) != 0){
			int[] numeros = new int[frase*6];
			boolean[] numeros_aux = new boolean[49];
			boolean incompleto = false;
			
			for(int i = 0; i < frase*6; i++){
				//for(int j = 0; j < 6; j++){ 
					numeros[i] = sc.nextInt()-1;
				//}
			}
			
			for(int i = 0; i < frase*6; i++){
				numeros_aux[numeros[i]] = true; 
			}

			for(int i = 0; i < 49; i++){
				if(numeros_aux[i]==false){
					incompleto = true;
					System.out.println("No");
					break;
				}
			}
			if(!incompleto)System.out.println("Yes");
		}
	}
	
}