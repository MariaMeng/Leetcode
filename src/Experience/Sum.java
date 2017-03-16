package Experience;

/**
 * Created by apple on 17/3/8.
 */
public class Sum {
    public static int sumSum;
    public static synchronized void setSum(int s) {
        sumSum = s;
    }
}
