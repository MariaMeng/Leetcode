package Experience;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by apple on 17/3/8.
 */
public class CatComparator implements Comparator<Cat> {
    int age;
    public int compare(Cat a, Cat b) {
        return a.age - b.age;
    }
    public static void main(String[] args) {
        CatComparator cc = new CatComparator();
        List<Cat> myList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            myList.add(new Cat(10 - i));
        }
        /*
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i).age);
        }*/
        Collections.shuffle(myList);
        for (Cat c : myList)
            System.out.println(c.age);
        Collections.sort(myList, cc);
        System.out.println();
        for (Cat c : myList)
            System.out.println(c.age);
        String str = "sss";
        System.out.println(str.hashCode());
    }

}
