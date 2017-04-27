package Experience.Alibaba;

import java.util.Scanner;

/**
 * Created by apple on 17/4/26.
 * 阿里的消息中间件，负责淘宝天猫支付宝等各个系统的消息中转，削峰填谷及架构的解耦。在每年的双11中承载了数万亿的消息。
 * 消息中间件中有Pub/Sub两个角色，Pub方发送消息到消息中间件，消息中间件再根据订阅关系投递给订阅方。
 * 例如用户成功购买了一个物品，交易平台（Pub）会发送一条交易完成（trade-done）的消息，
 * 购物车平台（Sub）订阅到这个消息后，会将用户的购物车物品删除掉。
 * 这里涉及一个问题，交易平台会发送各种类型的消息，消息中间件是如何准确的将相应的消息投递给购物车平台的？
 * 所使用的就是消息中间件的过滤功能，过滤的方式有很多种，表达式判断，正则匹配等。
 * 假设让你来实现一个过滤功能，来匹配订阅关系是否符合，给定如下条件：
 ‘?’ 匹配一个字符
 ‘*’ 匹配任意连串的字符
 如上面的例子中，购物车平台订阅方式是pattern=*trade-done，那么
 filter(100-trade-done, pattern) = 1,
 filter(200-trade-done, pattern) = 1,
 filter(200-paid-done, pattern) = 0

 如果pattern=200-?*-done :
 filter(100-trade-done, pattern) = 0,
 filter(200-trade-done, pattern) = 1,
 filter(200-paid-done, pattern) = 1

 如果pattern=1*trade*done :
 filter(100-trade-done, pattern) = 1,
 filter(200-trade-done, pattern) = 0,
 filter(200-paid-done, pattern) = 0
 输入为 第一行为：文本串
 第二行为：匹配串
 返回 1： 匹配
 0： 不匹配

 LEETCODE 原题 wildcard matching
 */
public class Main12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String p = in.nextLine();
        if (isMatch(s, p)) {
            System.out.println(1);
        } else
            System.out.println(0);
    }
    public static boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        int match = 0, nextIdx = -1;
        while (i < s.length()) {
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                nextIdx = j;
                match = i;
                j++;
            } else if (nextIdx != -1) {
                j = nextIdx + 1;
                match++;
                i = match;
            } else
                return false;
        }
        while (j < p.length()) {
            if (p.charAt(j) == '*') j++;
            else break;
        }
        return j == p.length();
    }
}
