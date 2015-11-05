import java.util.*;
import java.io.*;
import java.awt.geom.*;

/**
 * Created by caioa_000 on 10/03/2015.
 */
public class IntersectingLines {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        String frase;

        try {
            while (true) {
                int cont =  Integer.parseInt(sc.nextLine());

                System.out.println("INTERSECTING LINES OUTPUT");

                for(int i =0 ; i < cont ; i++){
                    frase = sc.nextLine();
                    String[] tokens  = frase.split(" ");
                    double x1 = Double.parseDouble(tokens[0]), y1=  Double.parseDouble(tokens[1]), x2=  Double.parseDouble(tokens[2]),
                            y2 =  Double.parseDouble(tokens[3]), x3 =  Double.parseDouble(tokens[4]),y3=  Double.parseDouble(tokens[5]),
                            x4 =  Double.parseDouble(tokens[6]), y4 =  Double.parseDouble(tokens[7]);
                    Line2D linha1 =  new Line2D.Double(x1, x2,y1,y2);
                    Line2D linha2 =  new Line2D.Double(x3, x4,y3,y4);

                    System.out.println("POINT");

                    if(linha1.intersectsLine(linha2)) {
                        System.out.println("POINT");
                        System.out.println("LINE");
                    }else{
                        System.out.println("NONE");
                    }
                }

            }
        }catch(Exception ex){

        }

        System.out.println("END OF OUTPUT");
    }

}


/*
5
0 0 4 4 0 4 4 0
5 0 7 6 1 0 2 3
5 0 7 6 3 -6 4 -3
2 0 2 27 1 5 18 5
0 3 4 0 1 2 2 5
*/