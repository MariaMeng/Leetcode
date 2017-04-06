package Experience;

import java.util.Scanner;

/**
 * Created by apple on 17/3/25.
 */
public class Number3 {
    public static void main(String[] args) {
        Scanner my = new Scanner(System.in);

        /*
        String[] firstLine = my.nextLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);
        */

        int n = Integer.parseInt(my.next());
        int k = Integer.parseInt(my.next());


        String str = my.nextLine();
        //if (str.equals(""))
        String[] secondLine = my.nextLine().split(" ");
        //if (secondLine[0].equals("")) return ;

        int[] arr = new int[secondLine.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(secondLine[i]);
        }

        if (arr.length != n) return ;

        afterKtimes(arr, k);
        for (int a : arr) {
            System.out.print(a + "\t");
        }
    }
    private static void afterKtimes(int[] arr, int k) {
        if (arr == null || arr.length == 0) return ;
        for (int i = 1; i <= k; i++) {
            int temp = arr[0];
            for (int j = 0; j < arr.length; j++) {
                if (j == arr.length - 1)
                    arr[j] += temp;
                else
                    arr[j] += arr[j + 1];
                if (arr[j] >= 100) {
                    arr[j] %= 100;
                }
            }
        }
    }
}
