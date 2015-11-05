import java.util.*;
import java.io.*;


public class Calculation{

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase;
		
		//try{
			//while(true){
				int inp = Integer.parseInt(sc.nextLine());
				
				//System.out.println(inp);
				
				for(int k = 0; k < inp; k++){
					System.out.println("------+---------");
					System.out.println(" time | elapsed");
					System.out.println("------+---------");
					frase = sc.nextLine();
					//System.out.println(frase);
					String[] tokens = frase.split(" ");
					
					int start_hour = Integer.parseInt(tokens[0]);
					int elapsed = Integer.parseInt(tokens[1]);
					int duration_h = Integer.parseInt(tokens[2]);
					int duration_minutes = Integer.parseInt(tokens[3]);

					if (duration_minutes + elapsed >= 60) duration_h += 1;
				
					for(int i = 0; i <= duration_h; i++){
						String sum = String.valueOf(start_hour+i);
						if(Integer.parseInt(sum) > 12) sum = String.valueOf(start_hour+i-12);
						if(Integer.parseInt(sum) < 10) sum = " " + sum ;
						if(i==0){
							if(elapsed == 0) System.out.println(sum + ":XX | XX");
							else{
								System.out.println(sum + ":XX | XX - " + elapsed);
								elapsed = -elapsed;
							}
						}else System.out.println(sum + ":XX | XX + " + elapsed);
						elapsed += 60;
					}
				}
			//}
		//}catch(Exception e){}

	}
}
