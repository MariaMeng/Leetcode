import java.util.*;
/**
 * Created by apple on 17/2/16.
 * Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.
 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:
 Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombOfPhoneNum {
    public final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations (String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) return list;
        backtrack(list, "", digits, 0);
        return list;
    }
    private void backtrack(List<String> list, String str, String digits, int start) {
        if (start == digits.length()) {
            list.add(str);
            return;
        }
        String target = KEYS[digits.charAt(start) - '0'];
        for (int i = 0; i < target.length(); i++) {
            backtrack(list, str + target.charAt(i), digits, start + 1);
        }
    }
    public static void main(String[] args) {
        String digits = "01";
        LetterCombOfPhoneNum mySolution = new LetterCombOfPhoneNum();
        List<String> list = mySolution.letterCombinations(digits);
        System.out.println(list);
    }

}
