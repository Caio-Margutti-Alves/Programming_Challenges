import java.util.*;
import java.io.*;


public class Voting {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase;
		
		while(!(frase = sc.nextLine()).equals("#")){
			String[] tokens = frase.split(" ");
			int[] votes = new int[4];
										
			for(int i = 0; i < frase.length(); i++){
				if(frase.charAt(i)=='Y')
					votes[0] += 1;
				else if(frase.charAt(i)=='N')
					votes[1] += 1;
				else if(frase.charAt(i)=='P')
					votes[2] += 1;
				else 
					votes[3] += 1;
			}
				
			int total_pre = votes[0] + votes[1] + votes[2];
				
			if(total_pre > votes[3]){
				if(votes[0] > votes[1])	System.out.println("yes");
				else if(votes[0] == votes[1]) 	System.out.println("tie");
				else System.out.println("no");
			}else System.out.println("need quorum");
		}
	}
}
