package Experience.DesignPattern.Decorator;

import Experience.DesignPattern.Decorator.Decorator;

/**
 * Created by apple on 17/3/5.
 */
public class ManDecoratorA extends Decorator {
    public void eat() {
        super.eat();
        reEat();
        System.out.println("ManDecoratorA类");
    }
    public void reEat() {
        System.out.println("再吃一顿饭");
    }
}
