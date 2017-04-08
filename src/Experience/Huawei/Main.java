package Experience.Huawei;

import java.util.Scanner;

/**
 * Created by apple on 17/4/7.
 */
public class Main {
    static int count = 0;
    public static void main(String[] args) {
        int n = 1000;
        for (int i = 0; i <= 1000; i++) {
            findShui(i);
        }
        System.out.println("水仙花总和为： " + count);
    }
    private static void findShui(int n ) {
        int sum = 0;
        int acc = 0;
        int copy = n;
        while (n / 10 != 0) {
            acc++;
            n = n / 10;
        }
        acc++;
        int num = acc;
        while (copy / 10 != 0) {
            sum += Math.pow((copy % 10), num);
            copy = copy / 10;
        }
        sum += Math.pow((copy % 10), num);
        if (sum == n) {
            count++;
            System.out.println("第" + count + "个水仙花数：" + n);
        }
    }
}
