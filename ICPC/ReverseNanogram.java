import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ReverseNanogram {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase;
			
		while(!(frase = sc.nextLine()).equals("0")){
			int n = Integer.parseInt(frase);
            char[][] nanogram =  new char[n][n];
            LinkedList<Integer>[] side = new LinkedList[n];
            LinkedList<Integer>[] top = new LinkedList[n];

            for(int i  = 0; i < n; ++i) {
                side[i] = new LinkedList<Integer>();
                top[i] = new LinkedList<Integer>();
            }

            for(int i  = 0; i < n; ++i){
                frase = sc.nextLine();
                for(int j = 0; j < n; ++j){
                    nanogram[i][j] = frase.charAt(j);
                }
            }

            for(int i  = 0; i < n; ++i){
                Integer count1 = 0, count2 = 0;
                for(int j = 0; j < n; ++j){
                    if(nanogram[i][j] == 'X'){
                        count1++;
                    }else if(count1!=0){
                        side[i].add(side[i].size(), count1);
                        count1 = 0;
                    }
                    if(nanogram[j][i] == 'X'){
                        count2++;
                    }else if(count2!=0){
                        top[i].add(top[i].size(), count2);
                        count2 = 0;
                    }
                }
                if(count1!=0)side[i].add(side[i].size(), count1);
                if(count2!=0)top[i].add(top[i].size(), count2);
            }

		    for(LinkedList<Integer> linha : side){
                if(linha.size() == 0) System.out.print("0");
                for(Integer num : linha){
                    System.out.print(num + " ");
                }
                System.out.println();
            }

            for(LinkedList<Integer> linha : top){
                if(linha.size() == 0) System.out.print("0");
                for(Integer num : linha){
                    System.out.print(num + " ");
                }
                System.out.println();
            }
				
		}
	}
}