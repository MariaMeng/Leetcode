package Experience;

import java.util.Scanner;

/**
 * Created by apple on 17/3/25.
 */
public class Number1 {
    public static void main(String[] args) {
        Scanner my = new Scanner(System.in);
        int taxiNum = Integer.parseInt(my.nextLine());
        String[] myX = my.nextLine().split(" ");
        String[] myY = my.nextLine().split(" ");
        String[] off = my.nextLine().split(" ");
        String[] time = my.nextLine().split(" ");
        int[] x = new int[myX.length];
        int[] y = new int[myY.length];
        for(int i = 0; i < myX.length; i++) {
            x[i] = Integer.parseInt(myX[i]);
            y[i] = Integer.parseInt(myY[i]);
        }
        int[] office = new int[off.length];
        for (int i = 0; i < off.length; i++) {
            office[i] = Integer.parseInt(off[i]);
        }
        int[] timeAll = new int[time.length];
        for (int i = 0; i < time.length; i++) {
            timeAll[i] = Integer.parseInt(time[i]);
        }
        int idx = findNearest(x, y);
        int walkTime = 15 * (Math.abs(x[idx]) + Math.abs(y[idx]));
        System.out.println(walkTime);

    }
    private static int findNearest(int[] x, int[] y) {
        int count = 0;
        int idx = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < x.length; i++) {
            count += Math.abs(x[i]);
            count += Math.abs(y[i]);
            if (min > count) {
                idx = i;
                min = count;
            }
        }
        System.out.println(idx);
        return idx;
    }
}
