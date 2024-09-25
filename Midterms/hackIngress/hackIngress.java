package Midterms.hackIngress;
import java.util.*;

public class hackIngress{
    static Scanner s = new Scanner(System.in);
    static int count = 0, success = 0, first = 0;
    static int[] cycle = new int[4];

    static void solve(){
        int time;
        time = s.nextInt();

        if (first == 0) { // constructs the beginning of the cycles
            first = time % 60;
            cycle[0] = time;
            count++;
            success++;
        }
        else if (time >= cycle[0] + 400 + first || cycle[0] - time >= 1900 + first){ // checks if the number inputted starts a new cycle
            // ISSUE: logical error with syntax: difficulties with time resets
            cycle[0] = time;
            count = 0;
            count++;
            success++;
        }
        else if (time >= cycle[count-1] + 5 && count < 4){ // checks if the hack is successful or within the cycle
            cycle[count] = time;
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

            for (int i = 0; i < n; i++) {
                solve();
            }
            System.out.println(success);
        }
    }
}
