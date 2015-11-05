import java.util.*;
import java.io.*;
import java.util.Arrays;

public class shuffles {

	public static void main (String[] args) {
		int shuffles, int deck_size;
		
		Scanner sc = new Scanner(System.in);
		deck_size = sc.nextInt();
		
		int[] deck = new int[deck_size];
		
		for (int i = 0; i < deck_size; i++){
			deck = sc.nextInt();
		}
		
		//countingSort(deck);
		
		for (int i = 0; i < array.lenght-1; i++){
			if (array[i] < array[i+1])shuffles++;
		}
		
		double output = Math.log((double)shuffles) / Math.log()
		System.out.println((int)Math.ceil(output));
		print(shuffle);

	}
	
	public static void countingSort(int[] a, int low, int high){
		int[] counts = new int[high - low + 1]; // this will hold all possible values, from low to high
		for (int x : a)
		counts[x - low]++; // - low so the lowest possible value is always 0
 
		int current = 0;
		for (int i = 0; i < counts.length; i++){
			Arrays.fill(a, current, current + counts[i], i + low); // fills counts[i] elements of value i + low in current
			current += counts[i]; // leap forward by counts[i] steps
		}
	}

}