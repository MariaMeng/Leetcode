package Experience;

/**
 * Created by apple on 17/3/4.
 */
public class Test {
    /*
    public static int X = 100;

    public final static int Y = 200;

    public Test() {
        System.out.println("Test构造函数执行");
    }
    static {
        System.out.println("static语句块执行");
    }

    public static void display() {
        System.out.println("静态方法被执行");
    }

    public void display_1() {
        System.out.println("实例方法被执行");
    }
    */
    public static void main(String[] args) {
        Shape shape = new Circle();
        System.out.println(shape.name);
        shape.printType();
        shape.printName();
    }
}
class Shape {
    public String name = "shape";

    public Shape(){
        System.out.println("shape constructor");
    }

    public void printType() {
        System.out.println("this is shape");
    }

    public static void printName() {
        System.out.println("shape");
    }
}

class Circle extends Shape {
    public String name = "circle";

    public Circle() {
        System.out.println("circle constructor");
    }

    public void printType() {
        System.out.println("this is circle");
    }

    public static void printName() {
        System.out.println("circle");
    }
}

