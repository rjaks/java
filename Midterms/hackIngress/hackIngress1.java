package Midterms.hackIngress;
import java.util.*;

public class hackIngress1 {
    static Scanner s = new Scanner(System.in);
    static int count, success, first;
    static int[] cycle;
    static boolean noFirst = true;

    static void solve(){
        int time = s.nextInt();
        int convertedtime =  ((time / 100) * 60) + (time % 100);
        
        if (noFirst){
            first = time % 100;
            cycle[0] = convertedtime;
            noFirst = false;
            count++;
            success++;
        }
        else if (count > 0 && convertedtime - cycle[0] >= 240 + first){
            cycle = new int[4];
            cycle[0] = convertedtime;
            count = 0;
            count++;
            success++;
        }
        else if (count > 0 && cycle[0] > 720 && convertedtime < 720 ){
            if ((1440 - cycle[count-1]) + convertedtime >= 5){
                cycle[count] = convertedtime;
                count++;
                success++;
            }
            else if ((1440 - cycle[count-1]) + convertedtime >= 240 + first){
                cycle = new int[4];
                cycle[0] = convertedtime;
                count = 0;
                count++;
                success++;
            }
        }
        else if (count > 0 && count < 4 && convertedtime - cycle[count-1] >= 5){
            cycle[count] = convertedtime;
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
