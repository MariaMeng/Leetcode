import java.util.*;
/**
 * Created by apple on 17/3/16.
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Some examples:
 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        String operator = "+-*/";
        Stack<String> stack = new Stack<>();
        for (String temp : tokens) {
            if (operator.contains(temp)) { // 当前temp为symbol
                int index = operator.indexOf(temp); // return current index
                int n1 = Integer.valueOf(stack.pop());
                int n2 = Integer.valueOf(stack.pop());
                switch(index) {
                    case 0 :
                        stack.push(String.valueOf(n1 + n2));
                        break;
                    case 1 :
                        stack.push(String.valueOf(n2 - n1));
                        break;
                    case 2 :
                        stack.push(String.valueOf(n2 * n1));
                        break;
                    case 3 :
                        stack.push(String.valueOf(n2 / n1));
                        break;
                }
            } else { // if temp is number
                stack.push(temp); // push into the stack
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
