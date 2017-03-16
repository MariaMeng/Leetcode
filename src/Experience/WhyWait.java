package Experience;

/**
 * Created by apple on 17/3/8.
 */
public class WhyWait extends Thread{
    private int sum;
    public WhyWait() {
    }
    /*
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                sum += i;
            }
            Sum.setSum(sum);
        }
    }*/
    public void run() {
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        Sum.setSum(sum);
    }
    public static void main(String[] args) {
        WhyWait ww = new WhyWait();
        ww.start();

        try {
            //Thread.sleep(0);
            ww.join();
        }catch(Exception e) {
            System.out.println(e);
        }

        System.out.println(Sum.sumSum);
    }


}
