import java.util.*;
import java.io.*;


public class LRUCaching {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase = sc.nextLine();
		int count = 1;
		
		
		while(!frase.equals("0")){
			String[] tokens = frase.split(" ");
			int MAX = Integer.parseInt(tokens[0]);
			LinkedList<Character> lista = new LinkedList<Character>();
			
			System.out.println("Simulation " + count++);
			
			for(int i = 0; i < tokens[1].length(); i++){
				char page = tokens[1].charAt(i);

				if(page == '!'){
					for(char c : lista) System.out.print(c);
					System.out.println();
				}
				else{
					if(lista.contains(page))lista.remove(lista.indexOf(page));
					else if(lista.size() == MAX)lista.pop();
					lista.add(page);
				}
			}
			frase = sc.nextLine();
		}
	}
}
