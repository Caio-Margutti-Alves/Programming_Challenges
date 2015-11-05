import java.util.*;
import java.io.*;

public class ImageCompression{


	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase;
		int count = 1;
		
			
		while(!(frase = sc.nextLine()).equals("0")){
			String[] tokens = frase.split(" ");
			int dimension = Integer.parseInt(tokens[0]);
			float percentage = Integer.parseInt(tokens[1]);
			
			//System.out.println(percentage);
			
			int[][] image  =  new int[dimension][dimension];
			
			for(int i = 0; i < dimension;  i++){
				frase = sc.nextLine();
				for(int j = 0; j < dimension;  j++){
					image[i][j] = Character.getNumericValue(frase.charAt(j));
				}
			}
			
			quadrantAnalysis(image, percentage, 0, 0, dimension - 1, dimension - 1);
			
			System.out.println("Image " +count++ + ":");

			for(int i = 0; i < dimension;  i++){
				for(int j = 0; j < dimension;  j++){
					System.out.print(image[i][j]);
				}
				System.out.println();
			}
		}
	}
	
	public static void quadrantAnalysis (int[][] image, float percentage, int width_s, int height_s, int width_e, int height_e) {
		if(width_s >= width_e || height_s >= height_e) return;
		else{
			int branco = 0, preto = 0;
			int sum = 0;
			
			/*for(int i = height_s; i<=height_e; i++){
				for(int j = width_s; j<=width_e; j++){
						System.out.print(image[i][j]);
					}
					System.out.println();
				}*/
			
			for(int i = height_s; i<=height_e; i++){
				for(int j = width_s; j<=width_e; j++){
					if(image[i][j]==0) branco++;
					else preto++;
				}
			}
			
			sum = preto + branco;
			float por_b =  ((float)branco/sum)*100, por_p = ((float)preto/sum)*100;
			//System.out.println("Branco :" + por_b); 
			//System.out.println("Preto :" + por_p);
			
			if(por_b >= percentage){
				for(int i = height_s; i<= height_e; i++){
					for(int j = width_s; j<= width_e; j++){
						image[i][j] = 0;
					}
				}
			}else if(por_p >= percentage){
				for(int i = height_s; i<= height_e; i++){
					for(int j = width_s; j<= width_e; j++){
						image[i][j] = 1;
					}
				}
			}else{
				int meio_x = (width_s + width_e) / 2;
				int meio_y = (height_s + height_e) / 2;
				quadrantAnalysis(image, percentage, width_s, height_s, meio_x, meio_y); 			//Quadrante esquerda sup.
				quadrantAnalysis(image, percentage, meio_x + 1, height_s, width_e, meio_y);		//Quadrante direita sup.
				quadrantAnalysis(image, percentage, width_s, meio_y + 1, meio_x, height_e);			//Quadrante esquerda inf.
				quadrantAnalysis(image, percentage, meio_x + 1, meio_y + 1, width_e, height_e);			//Quadrante direita inf.
			}
		}
	}
}