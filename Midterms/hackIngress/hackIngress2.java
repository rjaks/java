package Midterms.hackIngress;
import java.util.Scanner;

public class hackIngress2 {
    static Scanner s = new Scanner(System.in);
    static int count, success, first;
    static int[] cycle;
    static boolean noFirst = true;

    static void addcount(){
        count++;
        success++;
    }

    static void solve(){
        int time = s.nextInt();
        int convertedtime =  ((time / 100) * 60) + (time % 100);
        
        if (noFirst){
            first = time % 100;
            cycle[0] = convertedtime;
            System.out.print(time + " ");
            noFirst = false;
            addcount();
            return;
        }
        
        if (count > 0){
            if (count < 4){
                if (convertedtime < cycle[0]){ 
                    if ((1440 - cycle[count-1]) + convertedtime >= 240 + first){ // checks if the interval between the current time and first hack of the cycle is already past 4 hours
                        cycle = new int[4];
                        cycle[0] = convertedtime;
                        count = 0;
                        System.out.printf("| %d ", time);
                        addcount();
                    }
                    else {
                        cycle[count] = convertedtime;
                        System.out.print(time + " ");
                        addcount();
                    }
                }
                else if (convertedtime <= cycle[count-1]){  // checks if current < previous
                    if ( convertedtime < 720 && cycle[count-1] > 720){ // checks if current is AM and previous is PM
                        if ((1440 - cycle[count-1]) + convertedtime >= 240 + first){  // resets if the interval between previous and current is already 4 hours
                            cycle = new int[4];
                            cycle[0] = convertedtime;
                            count = 0;
                            System.out.printf("| %d ", time);
                            addcount();
                        }
                        else{
                            cycle[count] = convertedtime;
                            System.out.print(time + " ");
                            addcount();
                        }
                    }
                    else {
                        cycle = new int[4];
                        cycle[0] = convertedtime;
                        count = 0;
                        System.out.printf("| %d ", time);
                        addcount();
                    }
                }
                else if (convertedtime >= cycle[0] + 240 + first){ // resets the cycle if current is 4 hours ahead of the first hack in the cycle
                    cycle = new int[4];
                    cycle[0] = convertedtime;
                    count = 0;
                    System.out.printf("| %d ", time);
                    addcount();
                }
                else if (convertedtime >= cycle[count-1] + 5){ // adds to the if current is 5 mins ahead of previous
                    cycle[count] = convertedtime;
                    System.out.print(time + " ");
                    addcount();
                }
        }
            else if (convertedtime >= cycle[0] + 240 + first){ // resets the cycle if current is 4 hours ahead of the first hack in the cycle
                cycle = new int[4];
                cycle[0] = convertedtime;
                count = 0;
                System.out.printf("| %d ", time);
                addcount();
            }
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