/**
 * Created by apple on 17/1/27.
 * Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class ImplementStrStr {
    /*
        方法一： Brute force algorithm (暴力解): Time Complexity: O(mn)
     */
    public int strStr_A(String haystack, String needle) {
        if(haystack.length() == 0 && needle.length() == 0) return 0;
        int len1 = haystack.length(), len2 = needle.length(); // record the length of two strings
        for (int i = 0,j; i <= len1 - len2; i++) {
            for (j = 0; j < len2 && haystack.charAt(i + j) == needle.charAt(j); j++)
                ;
            if(j == len2)
                return i;
        }
        return -1;

    }
    /*
        方法一变体：暴力法(二)，采用Substring返回子字符串，再判断是否相等。
     */
    public int strStr_A_another(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        int len1 = haystack.length(), len2 = needle.length();
        for (int i = 0; i <= len1 - len2; i++) {
            String temp = haystack.substring(i, i+len2);
            if(temp.equals(needle))
                return i;
        }
        return -1;
    }

    public int strStr_A_another2(String haystack, String needle) {
        if (needle == null || haystack == null) return -1;
        if (needle.length() == 0) return 0;
        int len1 = haystack.length(), len2 = needle.length();
        int i = 0, j = 0;

        while(i < len1 && j < len2) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }else {
                i = i - j + 1;
                j = 0;
            }
        }
        if(j == len2) {
            return i - j;
        }else
            return -1;
    }

    /*
        方法二：采用KMP算法来优化，Time Complexity: O(m + n)
     */
    public int strStr_B(String haystack, String needle) {
        if(needle.length() == 0) return 0; //这步骤很重要！！！，如果匹配串为空，则调用setNext()函数时，会报错。
        int i= 0, j = 0; // two pointers
        char[] p = needle.toCharArray();
        int slen = haystack.length(), plen = needle.length();

        int[] next = setNext(p); // invoke the setNext method

        while(i < slen && j < plen) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) { //如果j = -1,则从头都不用匹配了，需要文本串增一，并且匹配串从头开始匹配
                ++i;
                ++j;
            }else
                j = next[j]; //字符对应的next 值会告诉你下一步匹配中，模式串应该跳到哪个位置
        }
        if(j == plen)
            return i - j;
        else return -1;
    }

    // 数组 p 一定非空，如果为空，调用setNext时，创建 next数组时，数组长度为零，next[0] = -1 会报错"Index Out of Bounds!".
    private int[] setNext(char[] p) {
        int[] next = new int[p.length];
        int plen = p.length;
        next[0] = -1;
        int k = -1, j = 0; // two pointers
        while(j < plen - 1) {
            if(k == -1 || p[j] == p[k]) {
                ++j;
                ++k;
                if(p[k] != p[j])
                    next[j] = k;
                else
                    next[j] = next[k];
            }else
                k = next[k];
        }
        return next;
    }


    public static void main(String[] args) {
        ImplementStrStr mySolution = new ImplementStrStr();
        String haystack = "aaa", needle = "aa";
        int result = mySolution.strStr_A_another2(haystack, needle);
        System.out.println(result);


    }
}
