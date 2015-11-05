import java.util.*;
import java.io.*;

public class PageMissing {

	public static void main (String[] args) {

		Scanner sc = new Scanner(System.in);
		String frase;
		
		while(!(frase = sc.nextLine()).equals("0")){
			int page_num, page_missing, page_sum;
			int[] pages =  new int[3];
			String[] tokens = frase.split(" ");
			page_num = Integer.parseInt(tokens[0]);
			page_missing = Integer.parseInt(tokens[1]);
			page_sum = page_num + 1;
			
			
			pages[0] = page_sum - page_missing;
			
			if(page_missing%2==0)pages[1] = page_missing-1;
			else pages[1] = page_missing+1;
			
			pages[2] = page_sum - pages[1];
			
			Arrays.sort(pages);	
			
			System.out.println(pages[0] + " " + pages[1] + " " + pages[2]);
			
		}
	}
}