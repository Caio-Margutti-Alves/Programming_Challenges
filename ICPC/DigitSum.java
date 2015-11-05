import java.util.*;
import java.io.*;

public class DigitSum{

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase;
			
		while(!(frase = sc.nextLine()).equals("0")){
			String[] tokens = frase.split(" ");
			Integer[] number = new Integer[Integer.parseInt(tokens[0])];
			LinkedList<Integer> gt_zero = new LinkedList<Integer>();
			
			int eq_zero = 0;
			int soma = 0;
				
			for(int i = 0; i < number.length;  i++){
				number[i] = Integer.parseInt(tokens[i+1]);
			}
			
			Arrays.sort(number, Collections.reverseOrder());
			
			for(int i = 0; i < number.length ;  i++){
				if(number[i]!=0) gt_zero.add(number[i]);
				else eq_zero++;
			}
			
			//System.out.println(eq_zero);
			
			for(int i = 0; i < number.length;  i++){
				if(gt_zero.size() - i == eq_zero-- ){
					soma +=  gt_zero.get(i) * Math.pow(10, (i/2) +1);
					//System.out.println(gt_zero.get(i) + " Sozinho");
				}else if(gt_zero.size() - i < eq_zero-- ){
					continue;
				}else{
					soma +=  gt_zero.get(i) * Math.pow(10, i/2);
						//System.out.println(gt_zero.get(i) + " Fator");
				}
			}
		
			System.out.println(soma);
				
		}
	}
}