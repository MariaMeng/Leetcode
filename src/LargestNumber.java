import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by maria on 17-5-26.
 *
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        // 1. 创建字符串数组
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        // 2. 采用Lambda方式
        Comparator<String> comp = (o1, o2) -> {
            String str1 = o1 + o2;
            String str2 = o2 + o1;
            return str2.compareTo(str1);
        };
        // 3. 根据定义的comparator进行排序
        Arrays.sort(str, comp);

        // 4. 如果全部为零，则直接返回
        if (str[0].charAt(0) == '0') return "0";

        // 5. 创建StringBuilder对象
        StringBuilder strB = new StringBuilder();
        for (String s: str) {
            strB.append(s);
        }
        return strB.toString();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.split(" ");



    }
}
