import java.util.*;
import java.io.*;

public class Duplicate{

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase;
			
		while(!(frase = sc.nextLine()).equals("0")){
			String[] tokens = frase.split(" ");
			LinkedList<Integer> list = new LinkedList<Integer>();
			boolean consecutive = false;
			
			int numbers = Integer.parseInt(tokens[0]);
			
			int last = -1;
			
			for(int i = 1 ; i <= numbers; i++){
				if(Integer.parseInt(tokens[i]) == last){
					consecutive = true;
				}else{
					last = Integer.parseInt(tokens[i]);
					list.add(last);
				}
			}
			
			if(consecutive){
				for(int number : list){
					System.out.print(number + " ");
				}
			}
			else{
				for(int i = 1 ; i <= numbers; i++){
					System.out.print(Integer.parseInt(tokens[i]) + " ");
				}
			}
			System.out.print("$");
			System.out.println();
		}
	}
}