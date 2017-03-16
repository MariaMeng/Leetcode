package Experience;

/**
 * Created by apple on 17/3/4.
 */
public class Dog {
    public Dog () {
        System.out.println("Dog Constructor");
    }
    public static void bark() {
        System.out.print("woof ");
    }
}

class Basenji extends Dog {
    public Basenji() {
        System.out.println("Basenji Constructor");
    }
    public static void bark() { }
}

class Bark {
    public static void main(String args[]) {
        Dog woofer = new Dog();
        Dog nipper = new Basenji();
        woofer.bark();
        nipper.bark();
    }
}
