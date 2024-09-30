package Midterms.hackIngress;
import java.util.*;

public class hackIngress{
    static Scanner s = new Scanner(System.in);
    static int count, success, first;
    static int[] cycle;
    static boolean noFirst = true;

    static void solve(){
        int time;
        time = s.nextInt();

        if (noFirst) { // constructs the beginning of the cycles
            first = time % 60;
            cycle[0] = time;
            System.out.print(time + " ");
            noFirst = false;
            count++;
            success++;
        }
        else if (count > 0 && time >= cycle[0] + 400 + first){ // checks if the number inputted starts a new cycle
            // ISSUE: logical error with syntax: difficulties with time resets
            cycle = new int[4];
            System.out.print(" | " + time + " ");
            cycle[0] = time;
            count = 0;
            count++;
            success++;
        }
        // 23 0600 0659 0700 0715 0719 0959 1000 1004 1030 1500 1505 1510 1512 1516 1521 1900 1831 1832 1948 2359 0000 0004 0430
        // 16 600 659 715 719 | 959 1004 1030 | 1500 1505 1510 1516 | 1900 1948 | 2359 0004 | 0430
        else if (count > 0 && cycle[0] > 1200 && time < 1200 ){
            if ((2400 - cycle[count-1]) + time >= 5){
                cycle[count] = time;
                System.out.printf("(%d)", cycle[count-1]);
                System.out.print(time + " ");
                count++;
                success++;
            }
            else if ((2400 - cycle[count-1]) + time >= 400 + first){
                cycle = new int[4];
                cycle[0] = time;
                System.out.print(" | " + time + " ");
                count = 0;
                count++;
                success++;
            }
        }
        else if (count > 0 && count < 4 && time - cycle[count-1] >= 5){ // checks if the hack is successful or within the cycle
            cycle[count] = time;
            System.out.printf("(%d)", cycle[count-1]);
            System.out.printf("[%d]", time - cycle[count-1]);
            System.out.print(time + " ");
            count++;
            success++;
        }
    }

    public static void main(String[] args){
        while(true){
            int n = s.nextInt();
            if ( n < 2 || n > 1000) System.exit(0);
            count = 0;
            first = 0;
            success = 0;
            cycle = new int[4];
            noFirst = true;

            for (int i = 0; i < n; i++) {
                solve();
            }
            System.out.println(success);
        }
    }
}
