import java.util.*;
/**
 * Created by apple on 17/3/27.
 */
public class Main {
    int count = 0;
    public int getNumber(String MerceCode, Map<String, String> map) {
        backtrack(MerceCode, map, 0);
        return count;
    }
    private void backtrack(String s, Map<String, String> map, int start) {
        if (start == s.length())  {
            count++;
            return ;
        }
        for (int i = start; i < s.length(); i++) {
            if (map.containsKey(s.substring(start, i + 1)))
                backtrack(s, map, i + 1);
        }
    }

}
