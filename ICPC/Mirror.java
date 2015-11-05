import java.util.*;
import java.io.*;


public class Mirror{

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase;
		
		while(!(frase = sc.nextLine()).equals("#")){
			char[] frase_aux = new char[frase.length()];
			boolean invalid = false;
			
			for(int i = 0, j = frase.length()-1; i < frase.length(); i++, j--){
				if(frase.charAt(i)=='p' || frase.charAt(i)=='i' ||
				frase.charAt(i)=='q'||
				frase.charAt(i)=='b'||
				frase.charAt(i)=='d' ||
				frase.charAt(i)=='o' || frase.charAt(i)=='v' || 
				frase.charAt(i)== 'w' || frase.charAt(i)== 'x'){
					char letra = frase.charAt(i);
					
					if(frase.charAt(i)=='p') letra = 'q';
					else if(frase.charAt(i)=='q') letra = 'p';
					else if(frase.charAt(i)=='b') letra = 'd';
					else if(frase.charAt(i)=='d') letra = 'b';

					frase_aux[j] += letra;
					
				}else{
					invalid =true;
					break;
				}
			}
			
			if(!invalid){
				for(char letra : frase_aux){
					System.out.print(letra);
				}
				System.out.println();
			}else{
				System.out.println("INVALID");
			}
			
		}
	}
}
