package Experience.Alibaba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 一个对于一个单行的逆波兰表达式，由如下元素构成：
 数字：十进制数字字符构成的正整数，比如 223
 运算符：支持三种运算符^+和*，分别代表自增，加法和乘法
 分隔符：一个或者多个空格
 例如下面的字符串就是个逆波兰表达式
 2 3  4 * ^ 5 +
 逆波兰表达式在一个基于栈的虚拟机中求解，虚拟机的栈能保存16个整数，虚拟机从左向右扫描表达式，
 遇到整数就压栈，遇到表达式则从栈顶弹出若干个整数进行计算，计算结果重新压回栈中。
 其中运算符^从栈顶弹出一个整数，增加1之后压栈；运算符+和*从栈顶弹出两个整数，分别做相加和相乘运算后压栈。
 如果遇到运算符的时候，栈内没有足够的整数，称为下溢出，返回-1；
 把整数压栈的时候，如果栈没有足够的空间，称为上溢出，返回-2；
 如果整个计算过程中没有发生溢出，在整个表达式求解完成后，返回栈顶的整数。
 */
public class Main13 {

    public static void main(String[] args) {

        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
    }

    // write your code here
    public static int resolve(String expr) {
        String[] token = expr.split(" ");
        Stack<Integer> stack = new Stack<>();
        int a, b;
        for (String s : token) {
            if (s.equals("+")) {
                if (stack.isEmpty()) {
                    return -1;
                } else {
                    a = stack.pop();
                }
                if (stack.isEmpty()) {
                    return -1;
                } else
                    b = stack.pop();
                stack.add(a + b);
            } else if (s.equals("*")) {
                if (stack.isEmpty()) {
                    return -1;
                } else {
                    a = stack.pop();
                }
                if (stack.isEmpty()) {
                    return -1;
                } else
                    b = stack.pop();
                stack.add(a * b);
            } else if (s.equals("^")) {
                if (stack.isEmpty()) {
                    return -1;
                } else {
                    a = stack.pop();
                    a = a + 1;
                    stack.add(a);
                }
            } else {
                if (stack.size() < 16) {
                    stack.push(Integer.valueOf(s));
                } else {
                    return -2;
                }
            }
        }
        return stack.pop();
    }
}
