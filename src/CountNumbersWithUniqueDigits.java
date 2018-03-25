/**
 * Created by maria on 17-11-9.
 */
public class CountNumbersWithUniqueDigits {
    public int countNumberWithUniqueDigits(int n) {
        if (n == 0) return 1;

        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        // n 控制 10以内的， availableNumber控制10以上的
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = availableNumber * uniqueDigits;
            res += uniqueDigits;
            availableNumber--;
        }
        return res;
    }

}
