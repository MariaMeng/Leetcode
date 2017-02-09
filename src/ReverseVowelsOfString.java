import java.util.HashSet;
import java.util.Set;

/**
 * Created by apple on 17/1/19.
 * Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:
 Given s = "hello", return "holle".

 Example 2:
 Given s = "leetcode", return "leotcede".

 Note:
 The vowels does not include the letter "y".
 注意：ReverseVowelsOfString 与 ReverseString 题目类似
 */
public class ReverseVowelsOfString {

    /*
        方法一： My Own Solutions
        但是在 inner while 循环中的condition 与标准答案不同
     */
    public String reverseVowels(String s) {
        if(s.length() == 0 || s == null) return "";
        int len = s.length(); // the length
        int left = 0, right = s.length() - 1; // two pointers
        String vowels = "aeiouAEIOU";
        char[] mycharArray = s.toCharArray();
        //System.out.println(mycharArray.toString());//mycharArray.toString()函数输出的为地址，转成String需要使用new String(mycharArray)

        //while(left < right) { // This condition can be omitted
        while(true) {
            while(left < len  && !vowels.contains(s.substring(left, left + 1)))
                left++;
            while(right >= 0 && !vowels.contains(s.substring(right, right + 1)))
                right--;
            // if the left pointer > right pointer jump out from the loop
            if (left >= right) break;
            //swap two vowels
            char temp = s.charAt(left);
            mycharArray[left] = mycharArray[right];
            mycharArray[right] = temp;
            // move the pointer to next positions
            left++;
            right--;
        }
        return new String(mycharArray);
    }

    /*
        方法二：采用 4 ms Java sol beats 95.6% 方法
        注意： 与自己不同的地方： 只有判断vowel中是否包含该字母
        我自己写的是 采用String类中的contains方法
        方法二写的是 自己编写 isVowel() 函数
     */
    public String reverseVowels_A(String s) {
        char[] ch = s.toCharArray();
        int i = 0, j = ch.length - 1;
        while(true) {
            while(j >= 0 && !isVowel(ch[j]))
                j--;
            while(i < ch.length && !isVowel(ch[i]))
                i++;
            if(i >= j)
                break;
            char tmp = ch[i];
            ch[i] = ch[j];
            ch[j] = tmp;
            j--;
            i++;
        }
        return new String(ch);
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    /*
        方法二：while循环中condition条件与自己写的不同，去掉了 "if (left >= right) break;" 部分
     */
    public String reverseVowels_B(String s) {
        if(s == null || s.length() == 0) return s;
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while(start < end) {

            //这里，这部分写的很好！
            while(start < end && !vowels.contains(chars[start] + "")){
                start++;
            }

            while(start < end && !vowels.contains(chars[end] + "")){
                end--;
            }

            //swap the two characters
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            //move two pointers towards and backwards
            start++;
            end--;
        }
        return new String(chars);
    }

    /*
        方法三：One pass Java Solution 13ms
        Set中元素不能重复
     */
    public String reverseVowels_C(String s) {
        char[] list=s.toCharArray();
        // input the all vowel characters whatever upper case or lower case
        Set<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        // two pointers
        for(int i=0,j=list.length-1;i<j;){ //采用for循环 来完成 双指针
            if(!set.contains(list[i])){ // If the Set does not contain current character for left pointer
                i++;
                continue;
            }
            if(!set.contains(list[j])){ // If the Set does not contain current character for right pointer
                j--;
                continue;
            }
            // swap the two vowel characters
            char temp=list[i];
            list[i]=list[j];
            list[j]=temp;
            // increase two pointers
            i++;
            j--;
        }
        return String.valueOf(list); //返回一个String类型
    }
    /*
        This variation of Method 3 can run 5ms
     */
    public String reverseVowels_C_another (String s) {
        char[] c = s.toCharArray();
        for (int i = 0, j = c.length - 1; i < j; ) {
            if(!isVowel_another(c[i])) {
                i++;
                continue;
            }
            if(!isVowel_another(c[j])) {
                j--;
                continue;
            }
            //swap the two vowel characters
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            // move two pointers forwards and backwards
            i++;
            j--;
        }
        return String.valueOf(c);
    }
    public boolean isVowel_another(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }



    public static void main(String[] args) {
        ReverseVowelsOfString mySolution = new ReverseVowelsOfString();
        String myString = "hello";
        String another = "concatenate";
        String result = mySolution.reverseVowels(another);
        System.out.println(result);
    }

}
