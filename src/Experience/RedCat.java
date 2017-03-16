package Experience;

import javax.print.attribute.standard.MediaSize;

/**
 * Created by apple on 17/3/4.
 */
public class RedCat extends Cat{
    protected void setname(String name) {
        super.setname(name);
        System.out.println(name);
    }
    public void setAge(int Nage) {
        age = Nage + 1;
    }

    public RedCat(String name) {
        super(name);
    }
    public int getAge() {
        return this.age;
    }

    public static void main(String[] args) {
        Cat myCat = new RedCat("catty");
        myCat.setAge(20);
        System.out.println(myCat.age);
        Cat myRedCat = new RedCat("putty");
        myRedCat.setAge(10);
        System.out.println(myRedCat.age);
        System.out.println(myCat.age);
        System.out.println(myCat.age);
        System.out.println(myCat.age);
        try {
            Class.forName("Cat");
        }catch(Exception e) {
            System.out.println(e);
        }
    }

}
class Cat {
    String name;
    public int age;
    public Cat(String name) {
        this.name = name;
    }
    public Cat() {
    }
    public Cat(int age) {
        this.age = age;
    }
    protected void setname(String name) {
        this. name = name;
    }
    protected String getName() {
        return this.name;
    }
    public void setAge(int Nage) {
        this.age = Nage;
    }

}
