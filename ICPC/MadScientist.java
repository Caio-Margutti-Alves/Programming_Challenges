import java.util.*;
import java.io.*;


public class MadScientist {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase;
		
		while(!(frase = sc.nextLine()).equals("0")){
			String[] tokens = frase.split(" ");
			int[] notes = new int[Integer.parseInt(tokens[0])];
			
			for(int i = 0; i < notes.length; i++){
				notes[i] = Integer.parseInt(tokens[i+1]);
			}
			
			int ant = 0;
			
			for(int i = 0; i < notes.length; i++){
					int resp = notes[i] - ant;
					if(resp != 0){
						for(int j = 0 ; j < resp; j++){
							//if(j!=resp-1)System.out.print(i+1 + " ");
							 System.out.print((i+1) + " " );
							// else System.out.print(i+1);
						}
					}
				 ant = notes[i];
			}
			System.out.println();
		}
	}
}
