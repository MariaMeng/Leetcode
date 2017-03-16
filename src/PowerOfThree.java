/**
 * Created by apple on 17/2/28.
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        /*
        return (Math.log(n) / Math.log(3)) % 1 == 0;
        */
        double temp = Math.log(n) / Math.log(3);
        double r = temp % 1;
        return r == 0; // 判断temp是否为小数还是整数
    }
    public static void main(String[] args) {
        int n = -27;
        PowerOfThree mySolution = new PowerOfThree();
        boolean result = mySolution.isPowerOfThree(n);
        System.out.println(result);
        System.out.println(Math.log(-27));



    }

}
