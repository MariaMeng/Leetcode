import java.util.Scanner;

/**
 * Created by apple on 17/4/26.
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 前提条件：已知所有测试用例为可以通过，即至少有一条路可以走完

 解题思路：
 采用最少的步数，到达终点
 让我们说当前跳转的范围是[curBegin，curEnd]，curFarthest是[curBegin，curEnd]中所有点可以达到的最远点。
 一旦当前点达到curEnd，然后触发另一个跳转，并用curFarthest设置新的curEnd，
 贪心算法： 找到当前最远能达到的点，之前最远的点，
 */
public class JumpGameII {
    public static int jump(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    public static int jump_B(int[] data) {
        int curEnd = 0, curFast = 0, jumps = 0;
        for (int i = 0; i < data.length - 1; i++) {
            curFast = Math.max(curFast, data[i] + i);
            if (i == curEnd) {
                jumps++;
                curEnd = curFast;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int n = str.length;
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(str[i]);
        }
        System.out.println(jump(data));
    }
}
