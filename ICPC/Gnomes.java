import java.util.*;
import java.io.*;

public class Gnomes{

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase = "";
			
		frase = sc.nextLine();	
			
		int filas = Integer.parseInt(frase);
		
		System.out.println("Gnomes:");
		
		for(int i = 0; i < filas; i++){
			frase = sc.nextLine();
			String[] gnomes = frase.split(" ");
			boolean asc = true, desc = true;
			
			int lastGnome = Integer.parseInt(gnomes[0]);
			
			for(String gnome : gnomes){
				if(Integer.parseInt(gnome) > lastGnome){
					desc = false;
				} else {
					lastGnome = Integer.parseInt(gnome);
				}
			}
			
			lastGnome = Integer.parseInt(gnomes[0]);
			
			for(String gnome : gnomes){
				if(Integer.parseInt(gnome) < lastGnome){
					asc = false;
				} else {
					lastGnome = Integer.parseInt(gnome);
				}
			}
			
					if(asc || desc)System.out.println("Ordered");
		else System.out.println("Unordered");
		}
	}
}