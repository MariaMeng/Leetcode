package Experience;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by apple on 17/3/10.
 * 注意事项：
 * 实现Comparator类的时候，原始类Man(可以想成从一个外部JAR包中导入的类)，没有可比较的方法，我们要做的就是对原始类，进行扩展，使得原来不可比的两个Object,可以相比
 */
public class ManComparator implements Comparator<Man> {
    public int compare (Man a, Man b) {
        return a.age - b.age;
    }
    public static void main (String[] args) {
        List<Man> list = new ArrayList<>();
        list.add(new Man(30, 3000));
        list.add(new Man(30, 2000));
        list.add(new Man(30, 1000));
        list.add(new Man(20, 2000));
        list.add(new Man(20, 1000));
        list.add(new Man(10, 1000));

        ManComparator myManComparator = new ManComparator();
        Collections.sort(list, myManComparator);
        for (Man man : list) {
            System.out.println(man.age + ", " + man.salary);
        }
    }
}
