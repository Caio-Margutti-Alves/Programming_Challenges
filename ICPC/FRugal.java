import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by caioa_000 on 11/03/2015.
 */
public class FRugal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase = "";

        while (!(frase = sc.nextLine()).equals("#")) {
            LinkedList<String> lista = new LinkedList<String>();
            String word = "";

            lista.add(frase);

            while (!(frase = sc.nextLine()).equals("*")) {
                lista.add(frase);
            }

            while (!(frase = sc.nextLine()).equals("**")) {
                boolean match =false;
                if(lista.contains(frase)) System.out.println(word);
                else{
                    Pattern r = Pattern.compile(frase);
                    for(String teste : lista){
                        Matcher m = r.matcher(teste);
                        if(m.find( )){
                            System.out.println(teste);
                            match = true;
                            break;
                        }
                    }
                }
                if (!match) System.out.println("NONE");
            }
            System.out.println("$");
        }
    }
}


