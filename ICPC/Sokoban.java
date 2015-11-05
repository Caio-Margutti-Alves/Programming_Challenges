import java.util.*;
import java.io.*;


public class Sokoban{

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase;
		int cont  = 1;
		
		while(!(frase = sc.nextLine()).equals("0 0")){
			String[] tokens = frase.split(" ");
			int alt  = Integer.parseInt(tokens[0]);
			int larg = Integer.parseInt(tokens[1]);
			char[][] tab = new char [alt][larg];
			char[][] mais = new char [alt][larg];
			String status = "";
			int[] player = new int[2];
			
			String moves = "";
		
			for(int i =0; i < alt ; i++){
				moves = sc.nextLine();
				for(int j =0; j < larg; j++ ){
					if(moves.charAt(j) == 'W' || moves.charAt(j) == 'w'){
						player[0] = i;
						player[1] = j;
						}
					mais[i][j] = moves.charAt(j);
					tab[i][j] = moves.charAt(j);
				}
			}
			
	
			moves = sc.nextLine();
			
		tudo:for(int i =0; i < moves.length(); i++){
				 status = "complete";
				//System.out.println(moves.charAt(i));
			all:for(int l = 0; l < alt ; l++){
					for(int j = 0; j < larg; j++){
						if(tab[l][j] != 'B' && mais[l][j] =='+' ){
							status = "incomplete";
							break all;
						}
					}
				}
				if (status.equals("complete")) break tudo;
				if(moves.charAt(i)=='U'){
					player = move(tab, mais, player[0],player[1], -1, 0);
				}else if(moves.charAt(i)=='D'){
					player = move(tab, mais, player[0],player[1], 1, 0);
				}else if(moves.charAt(i)=='L'){
					player = move(tab, mais,  player[0],player[1], 0, -1);
				}else if(moves.charAt(i)=='R'){
					player = move(tab, mais, player[0],player[1], 0, 1);
				}	
			}
			
			all: for(int i = 0; i < alt ; i++){
				for(int j = 0; j < larg; j++){
					if(tab[i][j] != 'B' && mais[i][j] =='+' ){
						status = "incomplete";
						break all;
					}
				}
			}
			
			System.out.println("Game " + cont++ + ": " + status);
			for(int i = 0; i < alt ; i++){
				for(int j = 0; j < larg; j++){
					System.out.print(tab[i][j]);
				}
				System.out.println();
			}
		}
	}
	
	public static int[] move (char[][] tab,char[][] mais, int x, int y, int k, int l){
		int k_linha = k*2, l_linha = l*2;
		
		int[] player = {x, y};
		
		if(x+k < tab.length && x+k >= 0 && y+l < tab[0].length && y+l >= 0){
			if(tab[x+k][y+l] == 'B' || tab[x+k][y+l] == 'b' ){
				if(tab[x+k_linha][y+l_linha] == '#' || tab[x+k_linha][y+l_linha] == 'B' || tab[x+k_linha][y+l_linha] == 'b'){
					return player;
				}
				else {
					if(mais[x+k_linha][y+l_linha] == '+')tab[x+k_linha][y+l_linha] = Character.toUpperCase(tab[x+k][y+l]);
					else tab[x+k_linha][y+l_linha] = Character.toLowerCase(tab[x+k][y+l]);
					if(mais[x+k][y+l]== '+')tab[x+k][y+l] =  Character.toUpperCase(tab[x][y]);
					else tab[x+k][y+l] = Character.toLowerCase(tab[x][y]);
					if(mais[x][y]== '+')tab[x][y] =  '+';
					else tab[x][y] = '.';
					player[0] = x+k;
					player[1] = y+l;
					return player;
				}
			}
			else if(tab[x+k][y+l] == '#'){
					player[0] = x;
					player[1] = y;
					return player;
			}
			else{
				if(mais[x+k][y+l]== '+')tab[x+k][y+l] =  'W';
				else tab[x+k][y+l] = 'w';
				if(mais[x][y]== '+')tab[x][y] =  '+';
				else tab[x][y] = '.';
				player[0] = x+k;
				player[1] = y+l;
				return player;
			}
		}else return player;
	}
	
}