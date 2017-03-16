package Experience;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by apple on 17/3/10.
 *注意事项：
 * 使用Comparable接口，目的在于，创建一个原始的类，使得这个类可以比较。
 */
public class Man implements Comparable <Man>{
    int age;
    int salary;
    public Man(int age, int salary) {
        this.age = age;
        this.salary = salary;
    }


    public int compareTo(Man man) {
       int result = this.age - man.age;
       if (result != 0)
           return result;
       else
           return this.salary - man.salary;
    }
    public static void main(String[] args) {
        List<Man> list = new ArrayList<>();
        list.add(new Man(30, 3000));
        list.add(new Man(30, 2000));
        list.add(new Man(30, 1000));
        list.add(new Man(20, 2000));
        list.add(new Man(20, 1000));
        list.add(new Man(10, 1000));
        System.out.println("排序之前，原始数据数据之后顺序：");
        for (Man man : list) {
            System.out.println(man.age + "," + man.salary);
        }
        System.out.println("排序之后，生序排列为如下：");
        Collections.sort(list);
        for (Man man : list)
            System.out.println(man.age + "," + man.salary);

    }
}
