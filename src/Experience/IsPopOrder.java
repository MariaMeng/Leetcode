package Experience;
import java.util.*;

/**
 * Created by apple on 17/3/18.
 */
public class IsPopOrder {
    public boolean isPopOrder(ArrayList<Integer> pushA, ArrayList<Integer> popA) {
        if (pushA.size() != popA.size()) return false;
        Stack<Integer> stack = new Stack<>();

        int j = 0; // point to the popA
        for (int i = 0; i < pushA.size(); i++) {
            stack.push(pushA.get(i));
            while (!stack.isEmpty() && stack.peek() == popA.get(j)) {
                stack.pop();
                j++;
            }
        }
        if (stack.isEmpty()) return true;
        else return false;
    }
    public static void main(String[] args) {

    }
}
