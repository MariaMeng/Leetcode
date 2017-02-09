import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 17/1/24.
 */
public class IntersectionOfTwoArraysII {

    /*
        方法一：Use HashMap method
        Concretely, This method stores num1 array in a HashMap, storing the elements together with occurrence for each.
        After that, retrieve each element in num2, judge whether the current element is in then key of HashMap and check
        its occurrence. If satisfy, then add into the ArrayList.
        Finally. transfer the ArrayList and return the array.
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums1 == null)
            return nums1;
        if (nums2.length == 0 || nums2 == null)
            return  nums2;
        Map<Integer,Integer> map1 = new HashMap<>();
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        // Add all elements w.r.t. occurrences into the map
        for (int a : nums1) {
            if (map1.containsKey(a))
                map1.put(a, map1.get(a) + 1);
            else
                map1.put(a, 1);
        }
        //Retrieve elements in nums2
        for (int b : nums2) {
            if(map1.containsKey(b) && map1.get(b) > 0) {
                arrayList1.add(b);
                map1.put(b, map1.get(b) - 1);
            }
        }
        int[] result = new int[arrayList1.size()];
        int i = 0;
        for (int d : arrayList1)
            result[i++] = d;
        return result;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArraysII mySolution = new IntersectionOfTwoArraysII();
        int[] nums1 = {};
        int[] nums2 = {1};
        int[] result = mySolution.intersect(nums1, nums2);
        for (int a : result)
            System.out.print(a + "\t");
    }
}
