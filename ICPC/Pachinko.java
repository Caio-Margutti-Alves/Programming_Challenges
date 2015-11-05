import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by caioa_000 on 11/03/2015.
 */
public class Pachinko {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase = "";

        while (!(frase = sc.nextLine()).equals("#")) {
            int j = 0;
            int porc = 0;

           for (int i = 0; i < frase.length() ; i++) {
               boolean esquerda = false, direita = false;
               int result = 0;
               if (frase.charAt(i) == '/') {
                    esquerda = true;
               } else if (frase.charAt(i) == '\\') {
                   direita = true;
               } else if (frase.charAt(i) == '.') {
                   result += 100;
               } else if (frase.charAt(i) == '|') {
                   esquerda = true;
                   direita = true;
               }


               if (esquerda) {
                   if(i-1 >= 0) {
                       for (int k = i-1; k >= 0 ; k--) {
                           if ((frase.charAt(k) == '_' && k == 0) || frase.charAt(k) == '.') {
                               result += 100;
                               break;
                           }else if(frase.charAt(k) != '_')break;
                       }
                   }else result+=100;
               }

               //System.out.println(i+"1: " + result);

               if (direita) {
                   if(i+1 < frase.length()) {
                       for (int k = i + 1; k < frase.length(); k++) {
                           if ((k == frase.length() - 1 && frase.charAt(k) == '_') || frase.charAt(k) == '.') {
                               result += 100;
                               break;
                           }else if(frase.charAt(k) != '_')break;
                       }
                   }else result+=100;
               }

               //System.out.println(i+"2: " + result);

               if(esquerda && direita && result != 0)result /= 2;
               //System.out.println(i+"3: " + result);
               porc += result;
               }

            //System.out.println(j);
            //System.out.println(porc);

            if(porc!=0) System.out.println(porc/frase.length());
            else System.out.println(porc);
        }
    }
}


