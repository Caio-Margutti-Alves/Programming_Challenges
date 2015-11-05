import java.util.Scanner;

/**
 * Created by caioa_000 on 11/03/2015.
 */
public class Root {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase = "";

        while (!(frase = sc.nextLine()).equals("0 0")) {
           String[] tokens = frase.split(" ");
            int B = Integer.parseInt(tokens[0]);
            int N = Integer.parseInt(tokens[1]);
            int resp = 0;
            int melhor = 1000000000;

            for (int i = 0; ; i++) {
                int result = (int) Math.pow(i, N);
                //System.out.println(result);
                if(Math.abs(result - B)<(Math.abs(melhor - B))){
                    resp = i;
                    melhor = result;
                }
                else break;
            }

            System.out.println(resp);
        }
    }
}


