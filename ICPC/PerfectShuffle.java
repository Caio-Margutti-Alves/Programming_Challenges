import java.util.*;
import java.io.*;

public class PerfectShuffle {

	public static void main (String[] args) {

		Scanner sc = new Scanner(System.in);
		String num_elementos = sc.nextLine();
		
		while(!num_elementos.equals("0")){
			String[] deck = new String[Integer.parseInt(num_elementos)];
			
			//System.out.println(num_elementos);
			
			for(int i = 0; i < Integer.parseInt(num_elementos); i++){
				if(i%2==0) deck[i] = sc.nextLine();
			}
			for(int i = 0; i < Integer.parseInt(num_elementos); i++){
				if(i%2==1) deck[i] = sc.nextLine();
			}
			
			for(int i = 0; i < deck.length; i++)System.out.println(deck[i]);
			
			num_elementos = sc.nextLine();
		}
	}
}