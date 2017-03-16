/**
 * Created by apple on 17/2/27.
 */
public class NumberOfOneBits {
    public int hammingWeight(int n) {
        int bitCount  = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1)
                bitCount++;
            n >>= 1;
        }
        return bitCount;
    }
    public static void main(String[] args) {
        NumberOfOneBits mySolution = new NumberOfOneBits();
        int n = Integer.MAX_VALUE;
        int result = mySolution.hammingWeight(n);
        System.out.println(result);
    }
}
