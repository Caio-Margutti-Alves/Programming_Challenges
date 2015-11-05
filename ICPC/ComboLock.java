import java.util.*;
import java.io.*;


public class ComboLock {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase;
		
		while(!(frase = sc.nextLine()).equals("0 0 0 0")){
			String[] tokens = frase.split(" ");
			int revolution = Integer.parseInt(tokens[0]);
			int ticks = 3*revolution + Integer.parseInt(tokens[1]) + (revolution - Integer.parseInt(tokens[1]));
							
			for(int i = 1; i < 3; i++){
				int var1 = Integer.parseInt(tokens[i]);
				int var2 = Integer.parseInt(tokens[i+1]);
				
				if(i%2==1){
					if(var1 < var2)	ticks += var2 - var1;
					else ticks += (revolution - var1) + var2;
				}
				else
					if(var1 > var2) ticks += var1 - var2;
					else ticks += var1 + (revolution - var2);
				}
				
			System.out.println(ticks - 1);
		}
	}
}
