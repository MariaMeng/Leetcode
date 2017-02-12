/**
 * Created by apple on 17/2/10.
 * Implement int sqrt(int x).

 Compute and return the square root of x.
 */
public class Sqrt {
    /*
        方法一： 牛顿迭代法
     */
    public int mySqrt(int x) {
        long r = x;
        while(r * r > x) {
            r = (r + x/r) / 2;
        }
        return (int)r;
    }

    /*
        方法二：二分查找
                Time Complexity: O(logn)
     */
    public int mySqrt_B(int x) {
        if (x == 0) return 0;
        int left = 1, right = x, ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Sqrt mySolution = new Sqrt();
        int result = mySolution.mySqrt(200);
        System.out.println(result);

    }
}
