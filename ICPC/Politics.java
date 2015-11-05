import java.util.*;
import java.io.*;


public class Politics {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase = "";
		
		while(!(frase = sc.nextLine()).equals("0 0")){
			int cont = 0;
			String[] tokens = frase.split(" ");
			int num_candidates = Integer.parseInt(tokens[0]);
			int num_supporters = Integer.parseInt(tokens[1]);
			
			LinkedList<String> candidates = new LinkedList<String>();
			LinkedList<String> candidates_write_in = new LinkedList<String>();
			
			TreeMap<String, LinkedList<String>> distribution = new TreeMap<String, LinkedList<String>>();
			TreeMap<String, LinkedList<String>> distribution_write_in = new TreeMap<String, LinkedList<String>>();
			
			for(int i =0; i < num_candidates ; i++){
				frase = sc.nextLine();
				//candidates_array[i] = frase;
				candidates.add(frase);
				//System.out.println("Candidato: " + candidates.get(i));
				
			}
			
			for(int i = 0; i < num_supporters; i++){
				frase = sc.nextLine();
				tokens = frase.split(" ");
				String name_supporter = tokens[0];
				String name_candidate = tokens[1];
				if(candidates.contains(name_candidate)){
					//System.out.println("Supporter: " + frase);
					if(!distribution.containsKey(name_candidate)){
						LinkedList<String> supporters = new LinkedList<String>();
						supporters.add(name_supporter);
						distribution.put(name_candidate, supporters);
					}else{
						LinkedList<String> supporters = distribution.get(name_candidate);
						supporters.add(name_supporter);
						distribution.put(name_candidate, supporters);
					}
				}else{
					if(!distribution_write_in.containsKey(name_candidate)){
						LinkedList<String> supporters = new LinkedList<String>();
						supporters.add(name_supporter);
						distribution_write_in.put(name_candidate, supporters);
						candidates_write_in.add(name_candidate);
					}else{
						LinkedList<String> supporters = distribution_write_in.get(name_candidate);
						supporters.add(name_supporter);
						distribution_write_in.put(name_candidate, supporters);
					}
				}
			}
			
			//Set<String> keys = distribution.keySet();
			
			if(candidates.size() > 0){
				for(String candidate : candidates){
					LinkedList<String> supporters = distribution.get(candidate);
					if(supporters!=null){
						for(String support : supporters){
							System.out.println(support);
						}
					}
				}
			}
			
			if(candidates_write_in.size() > 0){
				for(String candidate : candidates_write_in){
					LinkedList<String> supporters = distribution_write_in.get(candidate);
					if(supporters!=null){
						for(String support : supporters){
							System.out.println(support);
						}
					}
				}
			}
		}
	}
}
/*
3 6
MICHAELS
JORDAN
STEVENS
BOB JORDAN
JACK STEVENS
CAIO STEVENS
MACK MICHAELS
BILL JORDAN
CHRIS MATTHEWS
*/
