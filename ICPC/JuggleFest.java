import java.util.*;
import java.io.*;

public class JuggleFest {

	public static void main (String[] args) {

		Scanner sc = new Scanner(System.in);
		String frase = sc.nextLine();
		char[] letras = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T'};
		int MAX = 20;
		
		while(!frase.equals("0")){
			String[] pattern_aux = frase.split(" ");
			int size_pattern = Integer.parseInt(pattern_aux[0]);
			//int num_balls = size_pattern;
			int[] pattern = new int[size_pattern];
			String saida = "";
			boolean crash = false;
			int[] balls = new int[MAX];
			int i = 0;
			
			//System.out.println("Size: " + size_pattern);
			
			
			for(i = 0; i < size_pattern; i++){
				pattern[i] = Integer.parseInt(pattern_aux[i+1]);
			}
			
			balls[0]=1;
			
			int num_balls = 1, cont =0;
			
			
			loop:
			for(int j = 0; j < MAX; j++){
				int cur_ball = -1;
				for(i = 0; i < num_balls; i++){
					balls[i] = balls[i] - 1;
					//System.out.println("Bola: " + i + " valor: " + balls[i]);
					if(balls[i] == 0){
						if(cur_ball!=-1){
							crash = true;
							break loop;
						}else cur_ball = i;
					}
				}
				if(cur_ball == -1){
					num_balls++;
					//System.out.println(num_balls);
					saida += letras[num_balls-1];
					//System.out.println(saida);
					balls[num_balls-1] = pattern[cont % size_pattern];
				} else{
					//System.out.println(num_balls);
					saida += letras[cur_ball];
					//System.out.println(saida);
					balls[cur_ball] = pattern[cont % size_pattern];
				}
				cont++;
			}
			
			/*loop:
			for(int i = 0; i < MAX; i++){
				if(saida[i] == '\0'){
					num_balls++;
					saida[i] += letras[cont%num_balls];
					int next_move = i+pattern[cont%size_pattern];
					/System.out.println(next_move);
					if(next_move >= MAX) break;
					else if(saida[next_move] != '\0'){
						System.out.println("Crash true");
						crash = true;
						break loop;
					}else{
						saida[next_move] = letras[cont++%num_balls];
						System.out.println(next_move);
					}
				}
			}*/
			
			if(!crash){
				System.out.println(saida);
			}else System.out.println("CRASH");
			
			frase = sc.nextLine();
		}
	}
}
