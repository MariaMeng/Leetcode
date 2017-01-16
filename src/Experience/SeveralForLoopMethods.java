package Experience;


import java.util.*;

/**
 * Created by apple on 17/1/7.
 */
public class SeveralForLoopMethods {
    /*
        meth1： 最常见的for循环,遍历整个数组
     */
    public void meth1() {
        int[] myInt = {1, 2, 3, 4};
        for (int j = 0; j < myInt.length; j++) {
            int i = myInt[j];
            System.out.println(i);
        }
    }

    public void meth2() {
        String[] myString = {"A", "B", "C" ,"D"};
        Collection stringList = java.util.Arrays.asList(myString);
        //List<String> mystring = java.util.Arrays.asList(myString);
        /*
            Colletction produce the Interator
         */

        for (Iterator itr = stringList.iterator(); itr.hasNext();) {
            Object str = itr.next();
            System.out.println(str);
        }
    }

    /*
        for(循环变量类型 循环变量名称 ：要被遍历的对象) {
            循环体；
        }
     */
    public void meth3() {
        int[] myInt = {1, 2, 3, 4};
        for (int i : myInt) {
            System.out.print(i);
        }
    }

    /*
        遍历Collection的操作
     */
    public void meth4() {
        String[] strings = {"A", "B", "C","D"};
        Collection list = java.util.Arrays.asList(strings);
        for (Object str : list) {
            System.out.println(str);
        }
    }




}
