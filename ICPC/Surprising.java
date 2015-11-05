import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by caioa_000 on 11/03/2015.
 */
public class Surprising {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase = "";

        while (!(frase = sc.nextLine()).equals("*")) {
           boolean imp = true;


           tudo: for (int i = 1; i < frase.length() ; i++) {
               TreeSet<String> conjunto = new TreeSet<String>();
               int tamanho = 0;
                for (int j = 0, k = i; k < frase.length(); j++, k = j+i) {
                    String par = frase.charAt(j) + "" + frase.charAt(k);
                    //System.out.println(par);
                    tamanho = conjunto.size();
                    conjunto.add(par);
                    if(conjunto.size() == tamanho){
                        System.out.println(frase + " is NOT surprising.");
                        imp = false;
                        break tudo;
                    }
                }
            }
            if(imp)System.out.println(frase + " is surprising.");
        }
    }
}


