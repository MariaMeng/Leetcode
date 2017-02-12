import java.util.*;

/**
 * Created by apple on 17/2/10.
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

 Each LED represents a zero or one, with the least significant bit on the right.
 For example, the above binary watch reads "3:25".

 Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

 Example:

 Input: n = 1
 Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 Note:
 The order of output does not matter.
 The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
 注意事项：
 1. 采用两个list分别保存小时与分钟的数值。
 n = 2
 小时   分钟   list1(小时)        list2(分钟)
  0      2      0                 48, 40, 36, 34, 33, 24, ...
  1      1      8, 4, 2, 1        32, 16, 8, 4, 2, 1
  2      0      10, 9, 6, 5,...   0
 2. 采用backtrack回溯方法
 */
public class BinaryWatch {

    public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        int[] num1 = {8, 4, 2, 1}, num2 = {32, 16, 8, 4, 2, 1};
        for (int i = 0; i <= num; i++) {
            List<Integer> list1 = generateDigit(num1, i);
            List<Integer> list2 = generateDigit(num2, num - i);
            for (int n1 : list1) {
                if (n1 >= 12) continue;
                for (int n2 : list2) {
                    if (n2 >= 60) continue;
                    list.add(n1 + ":" + (n2 >= 10 ? n2 : "0" + n2));
                }
            }
        }
        return list;
    }

    private List<Integer> generateDigit(int[] num, int count) {
        List<Integer> res = new ArrayList<>();
        generateDigitHelper(num, count, 0, 0, res);
        return res;
    }

    private void generateDigitHelper(int[] nums, int count, int pos, int sum, List<Integer> res) {
        if (count == 0) {
            res.add(sum);
        }
        else {
            for (int i = pos; i < nums.length; i++) {
                generateDigitHelper(nums, count - 1, i + 1, sum + nums[i], res);
            }
        }
    }

    /*
        方法二： 暴力解，速度慢
     */
    public List<String> readBinaryWatch_B(int num) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++)
            for (int m = 0; m < 60; m++)
                if (Integer.bitCount(h) + Integer.bitCount(m) == num)
                    times.add(String.format("%d:%02d", h, m));
        return times;
    }
    public static void main(String[] args) {
        //System.out.println(Integer.bitCount(11));
        //System.out.printf("%d:%02d",1,1);
        BinaryWatch mySolution = new BinaryWatch();
        int num = 2;
        List list = mySolution.readBinaryWatch(num);
        System.out.println(list);
    }
}
