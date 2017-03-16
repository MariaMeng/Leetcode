package Experience.DesignPattern.Decorator;

/**
 * Created by apple on 17/3/5.
 */
public class Decorator implements Person {
    protected Person person;
    public void setPerson(Person person) {
        this.person = person;
    }
    public void eat() {
        person.eat();
    }
}
