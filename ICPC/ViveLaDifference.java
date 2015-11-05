import java.util.*;
import java.io.*;

public class ViveLaDifference {

	public static void main (String[] args) {
		int[] newArray = new int[4];
		int[] oldArray = new int[4];
		
		Scanner sc1 = new Scanner(System.in);
		
		while(sc1.hasNext()){
			String linha = sc1.nextLine();
			Scanner sc = new Scanner(linha);
			
			for(int i = 0; i < 4; i++){
				oldArray[i] = sc.nextInt();
				//System.out.println(oldArray[i]);
			}
			
			int cont = 0;
			while(!iguais(oldArray)){
				for(int j = 0; j < 4; j++){
					newArray[j%4] = Math.abs((oldArray[j%4] - oldArray[(j+1)%4]));
				}
				for(int j = 0; j < 4; j++){
					oldArray[j] = newArray[j]; 
					//System.out.println(oldArray[j]);
				}
				cont++;
			}
			System.out.println(cont);
		}
	}
	
	public static boolean iguais (int[] array) {
		for(int i = 0; i < array.length-1; i++){
			if(array[i] != array[i+1])return false;
		}
		return true;
	}
	
}