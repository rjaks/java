package Midterms.hackIngress;
import java.util.*;

public class hackIngress1 {
    static Scanner s = new Scanner(System.in);
    static int count, success, first;
    static int[] cycle;
    static boolean noFirst = true;

    static void addcount(){
        count++;
        success++;
    }

    // 53 0600 0659 0700 0715 0719 0959 1000 1004 1030 1500 1505 1510 1512 1516 1521 1900 0600 0659 0700 0715 0719 0720 0959 1000 1030 1500 1505 1600 1605 2112 0000 0111 0208 0731 0732 0733 0740 0856 0901 0906 1130 1131 1530 1629 1629 1628 1629 1519 1520 1524 1525 1539 0001
    // 600 659 715 959 | 1000 1030 | 1500 1505 1510 1516 | 1900 | 600 659 715 720 | 1000 1030 | 1500 1505 1600 1605 | 2112 0000 111 | 208 | 731 740 856 901 | 1131 1530 | 1629 | 1629 | 1628 | 1519 1524 1539 | 1
    // if current time < previous time, cycle resets

    static void solve(){
        int time = s.nextInt();
        int convertedtime =  ((time / 100) * 60) + (time % 100);
        
        if (noFirst){
            first = time % 100;
            cycle[0] = convertedtime;
            System.out.print(time + " ");
            noFirst = false;
            addcount();
        }
        else if (count < 4 && convertedtime < cycle[count]) { // resets if current < previous 
            cycle = new int[4];
            cycle[0] = convertedtime;
            count = 0;
        }
        else if (count < 4 && convertedtime == cycle[count]) { // resets if current == previous
            cycle = new int[4];
            cycle[0] = convertedtime;
            count = 0;
        }
        else if (count > 0 && count < 4 && convertedtime - cycle[count-1] >= 5){
            cycle[count] = convertedtime;
            System.out.print(time + " ");
            addcount();
        }
        else if (count > 0 && convertedtime - cycle[0] >= 240 + first){
            cycle = new int[4];
            System.out.printf("| %d", time);
            cycle[0] = convertedtime;
            count = 0;
            addcount();
        }
        else if (count > 0 && cycle[0] > 720 && convertedtime < 720 ){
            if ((1440 - cycle[count-1]) + convertedtime >= 5){
                cycle[count] = convertedtime;
                System.out.print(time + " ");
                addcount();
            }
            else if ((1440 - cycle[count-1]) + convertedtime >= 240 + first){
                cycle = new int[4];
                cycle[0] = convertedtime;
                System.out.printf("| %d ", time);
                count = 0;
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
