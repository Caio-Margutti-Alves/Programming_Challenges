import java.util.*;
import java.io.*;

public class Dull{

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase = "";
		
		while(!(frase = sc.nextLine()).equals("0")){
			LinkedList<Integer> dulls = new LinkedList<Integer>();
			HashMap<Integer, LinkedList<Integer>> prog = new HashMap<Integer, LinkedList<Integer>>();
			HashMap<Integer, Integer> running_dll =  new HashMap<Integer, Integer>();
				
			long max = 0, current = 0;
		
			char[] letras = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U'};
		
			int n = 0, p = 0, s = 0;
		
			String[] tokens = frase.split(" ");
			n = Integer.parseInt(tokens[0]);
			p = Integer.parseInt(tokens[1]);
			s = Integer.parseInt(tokens[2]);
			
			frase = sc.nextLine();
			tokens = frase.split(" ");
			
			for(int i = 0; i < n; i++){
				dulls.add(Integer.parseInt(tokens[i]));
			}
			
			for(int i = 0; i < p; i++){
				frase = sc.nextLine();
				tokens = frase.split(" ");
				
				LinkedList<Integer> space_libs = new LinkedList<Integer>();
				space_libs.add(Integer.parseInt(tokens[0]));
				
				String libs = tokens[1];
				
				for(int j = 0; j < libs.length(); j++){
					//System.out.println(libs.charAt(j));
					
					for(int k = 0; k < letras.length; k++){
						if(letras[k] == libs.charAt(j)){
							space_libs.add(k);
							//System.out.println(k);
						}
					}

					
				}
				prog.put(i, space_libs);
			}

			frase = sc.nextLine();
			tokens = frase.split(" ");
			
			for(int i = 0; i < tokens.length; i++){
				int program = Integer.parseInt(tokens[i]);
				int raw_program = Math.abs(program) - 1;
				
				LinkedList<Integer> space_libs = prog.get(raw_program);
				
				//sSystem.out.println(program);
					
				//System.out.println(max);
				
				if(program < 0)current -= space_libs.get(0);
				else current += space_libs.get(0);
				
				for(int j = 1; j < space_libs.size(); j++){
					if(program < 0){
						if(running_dll.get(space_libs.get(j)) == 1){
							current -= dulls.get(space_libs.get(j));
							running_dll.remove(space_libs.get(j));
						}
						
					}else{
						
						if(!running_dll.containsKey(space_libs.get(j))){
							//System.out.println(space_libs.get(j));
							current += dulls.get(space_libs.get(j));
							running_dll.put(space_libs.get(j),1);
						}else{
							int in = running_dll.get(space_libs.get(j))+1;
							
							running_dll.remove(space_libs.get(j));
							
							running_dll.put(space_libs.get(j),in);
						}
						if(current > max) max = current;
					}
				}

			}
			
			System.out.println(max);
			
		}

	}
}