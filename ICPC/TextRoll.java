import java.util.*;
import java.io.*;

public class TextRoll {

	public static void main (String[] args) {

		Scanner sc = new Scanner(System.in);
		int num_linhas = sc.nextInt();
		
		while(num_linhas != 0){
			String linhas = null;
			int last_index = -1;
			
			//System.out.println(num_linhas);
			
			for(int i = 0; i <= num_linhas; i++){
				String linha = sc.nextLine();
				//System.out.println(linha);
				int buraco = linha.indexOf(' ', last_index);
				if(buraco > last_index)last_index = buraco;
				else if(buraco == -1 && linha.length() > last_index)last_index = linha.length();
			}
			
			System.out.println(last_index+1);
			
			num_linhas = sc.nextInt();
		}
	}
}