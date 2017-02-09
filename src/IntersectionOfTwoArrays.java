import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by apple on 17/1/22.
 * Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

 Note:
 Each element in the result must be unique.
 The result can be in any order.
 */
public class IntersectionOfTwoArrays {
    /*
        方法一： My Own Solution
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> myset1 = new HashSet<>();
        Set<Integer> myset2 = new HashSet<>();

        for(int a : nums1)
            myset1.add(a);
        for (int i = 0; i < nums2.length; i++) {
            if(myset1.contains(nums2[i])) {
                myset2.add(nums2[i]);
            }
        }
        Integer[] IntArray = myset2.toArray(new Integer[] {});
        int[] result = new int[IntArray.length];
        for(int i = 0; i < IntArray.length; i++)
            result[i] = IntArray[i].intValue();
        return result;
    }

    public int[] intersection_B(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int a : nums1)
            set1.add(a);
        for (int b : nums2) {
            if (set1.contains(b))
                set2.add(b);
        }
        int[] result = new int[set2.size()];
        int i = 0;
        for (int c : set2)
            result[i++] = c;
        return result;
    }

    /*
        方法三： 比方法一效率高。来自Youtube中讲解。
     */
    public int[] intersection_C(int[] a, int[] b) {
        if(a == null || b == null)
            return null;
        //if(a.length == 0 || b.length == 0)
        //    return new int[0];
        Arrays.sort(a);
        Arrays.sort(b);

        Set<Integer> result = new HashSet<>();
        int i = 0, j =0;
        while(i < a.length && j < b.length) {
            if(a[i] == b[j]) {
                result.add(a[i]);
                i++;
                j++;
            }else if(a[i] < b[j]) {
                i++;
            }else {
                j++;
            }
        }
        int[] temp = new int[result.size()];
        int r = 0;
        for(int c :result) {
            temp[r++] = c;
        }
        return temp;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays mySolution = new IntersectionOfTwoArrays();
        int[] nums1 = {4, 1, 2, 3, 2, 1};
        int[] nums2 = {2, 1, 2};
        int[] result = mySolution.intersection_B(nums1,nums1);
        for(int a : result)
            System.out.print(a + "\t");
    }

}
