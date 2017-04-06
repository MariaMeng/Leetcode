package Experience.ACMBUPT;
import java.util.Scanner;

/**
 * Created by apple on 17/4/3.
 * 题目描述
 Some positive integers can be represented by a sum of one or more consecutive prime numbers.
 How many such representations does a given positive integer have?
 For example, the integer 53 has two representations: "5 + 7 + 11 + 13 + 17" and "53";
 The integer 41 has three representations: "2 + 3 + 5 + 7 + 11 + 13", "11 + 13 + 17", and "41".
 The integer 3 has only one representation, which is "3". The integer 20 has no such representations.
 Note that summands must be consecutive prime numbers,
 so neither "7 + 13" nor "3 + 5 + 5 + 7" is a valid representation for the integer 20.
 Your mission is to write a program that reports the number of representations for the given positive integer.

 输入格式
 The input is a sequence of positive integers, each in a separate line. You should read until the end of the input.
 The integers are between 2 and 1000000, inclusive.

 输出格式
 The output should be composed of lines each corresponding to an input line.
 An output line includes the number of representations for the input integer as the sum of one or more consecutive prime numbers.
 No other characters should be inserted in the output.

 输入样例
 2
 3
 17
 41
 20
 666
 12
 53
 输出样例
 1
 1
 2
 3
 0
 0
 1
 2
 */
public class SumOfPrime {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int []tag = new int[1000001];
        int count=0;
        for(int i=2; i<=100000; i++)
        {
            if(tag[i]==0)
            {
                for(int j=2;i*j<=1000000;j++)
                {
                    if(tag[i*j] ==0)
                    {
                        tag[i*j] =1;
                        count++;
                    }
                }
            }
        }

        int len = 1000000-count-1;

        int [] nums = new int[len]; // 保存的是所有素数
        count =0;
        for(int i=2;i<=1000000;i++)
            if(tag[i]==0)
                nums[count++]=i;

        while(in.hasNext())
        {
            int n = in.nextInt();
            int sum = 0;
            int res = 0;
            for(int j=0, i=0; i < len && j < len && nums[j] <= n; i++) {
                sum += nums[i];
                while(sum>n) {
                    sum-=nums[j];
                    if(nums[j] <=n && j<=i && j<len)
                        j++;
                    else
                        break;
                }
                if(sum == n)
                    res++;
            }
            System.out.println(res);
        }
    }
}
