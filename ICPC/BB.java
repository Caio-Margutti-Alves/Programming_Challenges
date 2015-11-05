import javafx.util.Pair;

import java.awt.Rectangle;
import java.util.*;
import java.util.function.BooleanSupplier;

public class BB {


	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase = "";

        while (!(frase = sc.nextLine()).equals("0")) {
            String[] tokens = frase.split(" ");
            int n, w, h;
            n = Integer.parseInt(tokens[0]);
            w = Integer.parseInt(tokens[1]);
            h = Integer.parseInt(tokens[2]);
            long boardArea = w * h;
            long bulletinArea = 0;
            long overlap_area = 0;
            int max_depth = 1;

            //TreeMap<Integer, Integer> row = new TreeMap<Integer, Integer>();
            Vector<Pair<Integer,Boolean>>[] board = new Vector[50000];

            for(int i = 0 ; i < 50000; i++){
                board[i] =  new Vector<Pair<Integer,Boolean>>();
            }

            for (int i = 0; i < n; i++) {
                frase = sc.nextLine();
                //System.out.println(frase);
                String[] tokens2 = frase.split(" ");
                int xl, yl, xh, yh;
                xl = Integer.parseInt(tokens2[0]);
                yl = Integer.parseInt(tokens2[1]);
                xh = Integer.parseInt(tokens2[2]);
                yh = Integer.parseInt(tokens2[3]);

                for(int j=xl; j<xh; ++j) {

                    board[j].add(new Pair(yl, true));
                    board[j].add(new Pair(yh, false));
                }
            }
               // System.out.println(yl + " " + yh);

            for(int i=0; i<50000; ++i) {
                Collections.sort(board[i], new PairComparator());
            }

            int areaCovered=0;
            // Maximum depth
            int mdepth = 0;

            // Go throw each row
            for(int i=0; i<50000; ++i) {
                // So far there is no poster
                int depth = 0;
                // Go throw each coordinate on that row
                for(int j=0; j<board[i].size(); ++j) {

                    // If the depth is at least 1, than this section has to be considered
                    if(depth > 0) {
                        // The size of this section is from the last point to the point I am now
                        areaCovered += board[i].get(j).getKey() - board[i].get(j-1).getKey();
                    }

                    // The depth is increased if this coordinate is a beggin and decreased if it's an end
                    if((Boolean) board[i].get(j).getValue() != false)
                        depth += 1;
                    else
                        depth -= 1;

                    // Save the maximum depth
                    mdepth = Math.max(mdepth, depth);
                }
            }
            // The area not covered it the total area minus the area covered
            System.out.print(h*w - areaCovered);

            // So far there i no areas with the max depth
            int maxDepthAreas = 0;
            // Go throw each row
            for(int i=0; i<50000; ++i) {
                // So far there is no poster, so the depth is 0
                int depth = 0;

                // Go throw each coordinate on that row
                for(int j=0; j<board[i].size(); ++j) {

                    // If the depth is equal to the maximum depth, than this section has to be considered
                    if(depth == mdepth)
                        maxDepthAreas += board[i].get(j).getKey() - board[i].get(j-1).getKey();

                    // The depth is increased if this coordinate is a beggin and decreased if it's an end
                    if((Boolean) board[i].get(j).getValue() != false)
                        depth += 1;
                    else
                        depth -= 1;
                }
            }

            System.out.print(" " + mdepth + " " + maxDepthAreas + "\n");
        }
    }

    public static class PairComparator implements Comparator<Pair>{
        public int compare(Pair o1, Pair o2)
        {
            return  Integer.parseInt(o1.getKey().toString()) -  Integer.parseInt(o2.getKey().toString());
        }
    }
}




