/**
 * Created by apple on 17/1/4.
 */
public class ReverseString {
    //方法一：use swap方法
    public String reverseString(String s){
        if(s ==null || s.length()==0 ) {
            return "";
        }
        char[] c = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while( left < right ) {
            //swap two characters
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;

            left++;
            right--;
        }
        return new String(c);
    }
    //方法二：采用StringBuilder类
    public String reverseStringAnother(String s) {
        StringBuilder myString = new StringBuilder(s);
        myString.reverse();
        return myString.toString();

    }
    public static void main( String args[]) {
        ReverseString mySolution = new ReverseString();
        String s = "hello";
        System.out.println(mySolution.reverseString(s));
        System.out.println(mySolution.reverseStringAnother(s));
    }
}
