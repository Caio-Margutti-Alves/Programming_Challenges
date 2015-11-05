import java.util.*;
import java.io.*;


public class Queens{

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase;
		
		while(!(frase = sc.nextLine()).equals("0")){
			String[] tokens = frase.split(" ");
			
			int size = Integer.parseInt(tokens[0]);
			int n_pattern = Integer.parseInt(tokens[1]);
			
			int[][] patterns = new int[n_pattern][5];
			LinkedList<int[]> queens_pos = new LinkedList<int[]>();

			int collisions = 0;
			
			for(int i = 0; i < n_pattern; i++){
				frase = sc.nextLine();
				String[] tokens2 = frase.split(" ");
				int k = Integer.parseInt(tokens2[0]);
				int x = Integer.parseInt(tokens2[1])-1;
				int y = Integer.parseInt(tokens2[2])-1;
				int s = Integer.parseInt(tokens2[3]);
				int t = Integer.parseInt(tokens2[4]);
				for(int m = 0; m < k; m++){
					int x1 = x+m*s;
					int y1 = y+m*t;
					int[] position = {x1,y1,x1+y1,y1+(size-x1)};
					queens_pos.add(position);
				}
			}
			
			for(int i = 0; i < size*2; i++){
				int cont_v = 0;
				int cont_h = 0;
				int cont_d = 0;
				int cont_i = 0;
				for(int[] position: queens_pos){
					if(position[0] == i) cont_v++;
					if(position[1] == i) cont_h++;
					if(position[2] == i) cont_d++;
					if(position[3] == i) cont_i++;
				}
				if(cont_v!=0)collisions += cont_v - 1; 
				if(cont_h!=0)collisions += cont_h - 1;
				if(cont_d!=0)collisions += cont_d - 1;
				if(cont_i!=0)collisions += cont_i - 1;
			}
			
			System.out.println(collisions);
		}
	}
}

/*			for(int i = 0; i < size; i++){
				for(int j = 0; j < size; j++){
					boolean print = false;
					for(int[] position: queens_pos){
						if(position[0] == i && position[1] == j){
							System.out.print(1);
							print = true;
						}
					}
					if(!print)System.out.print(0);
				}
				System.out.println();
			}
			*/