import java.util.*;
import java.io.*;

public class Minesweeper {

	public static void main (String[] args) {

		Scanner sc = new Scanner(System.in);
		String frase;
		int heigth, width;
		
		while(!(frase = sc.nextLine()).equals("0 0")){
			String[] tokens = frase.split(" ");
			heigth = Integer.parseInt(tokens[0]);
			width = Integer.parseInt(tokens[1]);
			char[][] board = new char[heigth][width];
			int[][] aux_board = new int[heigth][width];
			
			for(int i = 0; i < heigth; i++){
				String line  = sc.nextLine();
				for(int j = 0; j < width; j++){
					board[i][j] = line.charAt(j);
				}
			}
			
			for(int i = 0; i < heigth; i++){
				for(int j = 0; j < width; j++){
					if(board[i][j] == '*'){
						for(int k = -1; k <= 1; k++){
							for(int l = -1; l <= 1; l++){
								if(i+k >= 0 && i+k < heigth && j+l >= 0 && j+l < width){ 
									if(board[i+k][j+l] == '.')aux_board[i+k][j+l] += 1;
								}
							}
						}
					}
				}
			}

			for(int i = 0; i < heigth; i++){
				for(int j = 0; j < width; j++){
					if(aux_board[i][j]>=1)System.out.print(aux_board[i][j]);
					else{
						if(board[i][j] == '.')System.out.print(0);
						else System.out.print(board[i][j]);
					}
				}
				System.out.println();
			}
		}
	}
}