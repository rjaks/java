package Midterms.SeatPlanMakerV1;

import java.util.*;

public class SeatPlanMaker {
    static int r, rc, lc, seatcount = 1;
    static Scanner s = new Scanner(System.in);

    static void solve(){
        for (int j = 0; j < r; j++){
            for (int k = 0; k < lc; k++) {
                System.out.printf("[%02d]", seatcount);
                seatcount++;
            }
            System.out.print('\t');
            for (int l = 0; l < rc; l++) {
                System.out.printf("[%02d]", seatcount);
                seatcount++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        do{
            if (r * (lc + rc) > 99) System.out.println("Total number of seats should not exceed 99.");
            System.out.print("Enter row#, left column#, and right column#, separated by space: ");
            r = s.nextInt();
            lc = s.nextInt();
            rc = s.nextInt();
        }
        while (r * (lc + rc) > 99);
        solve();
    }
}
