package Experience;

/**
 * Created by apple on 17/1/15.
 * This class is used to test the difference between the two OR opererations:
 *  One Short Line | :
 *  Two Short Line || :
 */
public class TwoShortLineOR_OneShortLineOR {
    /*
        单| :
        无论第一个条件3>2是否为真，程序都会去执行判断第二个条件表达式，
        因此i++这个自增是会被执行的，再加上if内的i=i+1，所以最终i=2。
     */
    public void OneLineOR() {
        int i=0;
        if(3>2 | (i++)>1)
            i=i+1;
        System.out.println("One Line OR: " + i);
    }
    /*
        双||：
        如果第一个条件成立，第二个条件就不执行了。

     */
    public void TwoLineOR() {
        int i=0;
        if(3>2 || (i++)>1)
            i=i+1;
        System.out.println("Two Line OR: " + i);
    }
    public static void main(String[] args) {
        TwoShortLineOR_OneShortLineOR mySolution = new TwoShortLineOR_OneShortLineOR();
        mySolution.OneLineOR();
        mySolution.TwoLineOR();
    }


}
