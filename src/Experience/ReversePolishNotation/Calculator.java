package Experience.ReversePolishNotation;

import java.util.ArrayList;
import java.util.*;

/**
 * Created by apple on 17/3/16.
 */
public class Calculator {
    private List list = new ArrayList<>();
    private Stack stack = new Stack();

    /*
    private List resolveExpr(String exp) {
        String opert = exp.replaceAll("\\d*\\.\\d+?", "");
        List list = new ArrayList();
        int pidx = 1;
        for (int i = 0; i < opert.length(); i++) {
            String p = opert.substring(i, i + 1);
            pidx = exp.indexOf(p);
            if (exp.substring(0, pidx).trim().length() != 0) {
                list.add(exp.substring(0, pidx));
                String s = "s";


            }
        }
    }
    */
    public static void main(String[] args) {
        LinkedList<int[]> list = new LinkedList<int[]>();
        list.getFirst();
    }
}
