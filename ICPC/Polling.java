import java.util.*;
import java.io.*;


public class Polling {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		try{
			while(true){
				int num_candidates = Integer.parseInt(sc.nextLine());
				
				TreeMap<String, Integer> candidates = new TreeMap<String, Integer>();
				
				for(int i =0; i < num_candidates ; i++){
					String name_candidate = sc.nextLine();
					if(!candidates.containsKey(name_candidate))candidates.put(name_candidate, 1);
					else candidates.put(name_candidate, candidates.get(name_candidate)+1);
				}
				
				int maior = - 1;
				
				for (String key : candidates.keySet()) {
					if(candidates.get(key) > maior){
						maior = candidates.get(key);
					}
				}
				
				for (String key : candidates.keySet()) {
					if(candidates.get(key) == maior){
						System.out.println(key);
					}
				}
			}
		}catch(Exception e){}
		
	}
}
