import java.util.Scanner;

/**
 * Created by caioa_000 on 11/03/2015.
 */
public class Quicksum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase = "";
        char[] letras = {'A','B','C','D','E','F', 'G', 'H', 'I', 'J', 'K', 'L', 'M','N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y','Z'};

        while (!(frase = sc.nextLine()).equals("#")) {
            int count = 0;

            for (int i = 0; i < frase.length(); i++) {
                if (frase.charAt(i) != ' ') {
                    int number = 0;
                    for (int j = 0; j < letras.length; j++){
                        if(letras[j] == frase.charAt(i))number = j+1;
                     }
                    count += (i + 1) * number;
                }
            }
            System.out.println(count);
        }
    }
}


