package Experience;

import java.util.HashSet;

/**
 * Created by apple on 17/1/19.
 * 注意： 存入Set的每个元素都必须是唯一的。
 * 在本代码中，采用HashSet 类型的Set, 存储顺序不能保证。
 */
public class WhyStringIsImmutable {
    public void immutableString(String[] str) {
        HashSet<String> set = new HashSet<>();
        //input the set
        for (String myString : str)
            set.add(myString);
        for (String a : set) {
            a = "a";
        }
        //check that the order in printing differs from that in input
        for (String b : set)
            System.out.println(b);
    }
    public static void main(String[] args) {
        WhyStringIsImmutable mySolution = new WhyStringIsImmutable();
        String[] str = {"hello", "myString", "World", "new", "happy", "this", "that" ,"balbala"};
        mySolution.immutableString(str);
    }

}
