package Experience.DesignPattern.Decorator;

/**
 * Created by apple on 17/3/5.
 */
public class ManDecoratorB extends Decorator {
    public void eat() {
        super.eat();
        System.out.println("===============");
        System.out.println("ManDecoratorB类");
    }
    public static void main(String[] args) {
        Man man = new Man();
        ManDecoratorA md1 = new ManDecoratorA();
        ManDecoratorB md2 = new ManDecoratorB();
        md1.setPerson(man);
        md2.setPerson(md1);
        md2.eat();
    }
}
