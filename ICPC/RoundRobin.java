import java.util.*;
import java.io.*;

public class RoundRobin{

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase;
			
		while(!(frase = sc.nextLine()).equals("0")){
			String[] tokens = frase.split(" ");
			int num_players = Integer.parseInt(tokens[0]);
			int turns = Integer.parseInt(tokens[1]);
			boolean n_equal = true;
			
			LinkedList<Integer> players = new LinkedList<Integer>(num_players);
			int current  = 0;
			
			while(n_equal){
				n_equal = false;
				int avg = turns / players.size(); 
				int resto = turns % players.size();
				
				for(int i = 0; i < players.size();  i++){
					players.set(i, players.get(i) + avg); 
					if(resto-- > 0)players.set(i, players.get(i) + 1);
				}
				
				current = (current + turns) % players.size();
				
				players.remove(current-1);
			
				for(int i = 0; i < players.size() -1;  i++){
					if(players.get(i) != players.get(i+1)){
						n_equal = true;
					}
				}
				
				
			}
			
				System.out.print(players.size() + " " +  players.get(0));
				System.out.println();
			
		}
	}
}