package Experience.ACMBUPT;

import java.util.Scanner;

/**
 * Created by apple on 17/4/3.
 * 题目描述
 Kxzuir goes to a strange planet, however he knows nothing about that place.
 Fortunately, he carries n small balls with him, so he can figure out the gravitational acceleration g of the planet.
 He fixes the ith ball on the height hi, and then release the first ball at time 0. Once the ith ball hit the ground,
 he immediately release the (i+1)th ball, and so on.
 Now he knows the last ball hits the ground at time T, can you tell him the value of g?

 输入格式
 Multiple test cases, process until the end of the input.
 Each test case has two lines: the first line are two positive integers n,T(1≤n,T≤100), and the second line contains n integers,
 representing each ball's height hi(1≤hi≤100).

 输出格式
 For each test case, print a single line, the value of gravitational acceleration g, keep 7 decimal places.

 输入样例
 11 30
 16 23 85 3 35 72 96 88 2 14 63
 5 12
 3 1 3 1 3
 输出样例
 9.8037996
 0.7192307
 */
public class StrangePlanet {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext())
        {
            int n = in.nextInt();
            int time = in.nextInt();
            double temp =0.0;
            for(int i=0;i<n;i++) {
                int h = in.nextInt();
                temp+=Math.sqrt(h);
            }
            if(time>0)
            {
                temp = time/temp;
                System.out.printf("%.7f", 2.0/(temp*temp));
                System.out.println();
            }
            else {
                System.out.printf("%.7f", 0.0);
                System.out.println();
            }
        }
    }

}
