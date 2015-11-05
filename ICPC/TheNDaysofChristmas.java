import java.util.*;
import java.io.*;

public class TheNDaysofChristmas {

	public static void main (String[] args) {

		Scanner sc = new Scanner(System.in);
		Long i;
		
		while((i = sc.nextLong()) != 0){
			Long sum = i*(1+i)*(i+2)/6;
			System.out.println(sum);
		}
	}
}