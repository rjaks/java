package Midterms.SeatPlanMakerV2;

import java.util.*;

public class SeatPlanMakerV2 {
    static int r, rc, lc, seatcount = 1, reservedseat;
    static int[][] seats;
    static boolean isReserved = false;
    static Scanner s = new Scanner(System.in);

    static void generateSeats(){
        seats = new int[r][rc + lc];
        for (int i = 0; i < r; i++){
            for (int j = 0; j < lc; j++) {
                seats[i][j] = seatcount;
                seatcount++;
            }
            for (int k = lc; k < rc + lc; k++) {
                seats[i][k] = seatcount;
                seatcount++;
            }
        }
    }

    static void display(){
        for (int j = 0; j < r; j++){
            for (int k = 0; k < lc; k++) {
                if (seats[j][k] == 100) System.out.print("[XX]");
                else System.out.printf("[%02d]", seats[j][k]);
            }
            System.out.print("    ");
            for (int l = lc; l < rc + lc; l++) {
                if (seats[j][l] == 100) System.out.print("[XX]");
                else System.out.printf("[%02d]", seats[j][l]);
            }
            System.out.println();
        }
        System.out.print('\n');
    }

    static void reserve(int n){
        isReserved = true;
        for (int i = 0; i < r; i++){
            for (int j = 0; j < lc + rc; j++){
                if (n == seats[i][j]) {
                    seats[i][j] = 100;
                    isReserved = false;
                    display();
                    break;
                }
            }
        }
        if (isReserved) System.out.println("SEAT TAKEN.\n");
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
        
        generateSeats();
        display();

        System.out.print("Select seat number to take <Enter 0 to quit>: ");
        reservedseat = s.nextInt();
        while (reservedseat < 0 || reservedseat > 99){
            System.out.println("Invalid seat number.\n");
            System.out.print("Select seat number to take <Enter 0 to quit>: ");
            reservedseat = s.nextInt();
        }

        while (reservedseat != 0){
            reserve(reservedseat);
            System.out.print("Select seat number to take <Enter 0 to quit>: ");
            reservedseat = s.nextInt();
            while (reservedseat < 0 || reservedseat > 99){
                System.out.println("Invalid seat number.\n");
                System.out.print("Select seat number to take <Enter 0 to quit>: ");
                reservedseat = s.nextInt();
            }
        } 
    }
}
