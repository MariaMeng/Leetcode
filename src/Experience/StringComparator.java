package Experience;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by apple on 17/3/22.
 */
public class StringComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        /*
        String str1 = s1 + s2;
        String str2 = s2 + s1;
        return str1.compareTo(str2);
        */
        return s2.compareTo(s1);
    }
    public static void main(String[] args) {
        StringComparator strCom = new StringComparator();
        String[] str = new String[] { "121", "12"};
        Arrays.sort(str, strCom);
        for (String s : str)
            System.out.print(s + "\t");

    }
}
