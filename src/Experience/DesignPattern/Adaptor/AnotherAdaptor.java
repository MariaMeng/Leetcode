package Experience.DesignPattern.Adaptor;

/**
 * Created by apple on 17/3/5.
 */
public class AnotherAdaptor implements Target {
    // 直接关联被适配类
    private Adaptee adaptee;

    // 可以通过构造函数传入具体需要适配的被适配类对象
    public AnotherAdaptor (Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void request() {
        // 这里是使用委托的方式完成特殊功能
        this.adaptee.specificRequest();
    }

}
// 测试类
class Client {
    public static void main(String[] args) {
        // 使用普通功能类
        Target concreteTarget = new ConcreteTarget();
        concreteTarget.request();

        // 使用特殊功能类，即适配类，
        // 需要先创建一个被适配类的对象作为参数
        Target adapter = new AnotherAdaptor(new Adaptee());
        adapter.request();
    }
}