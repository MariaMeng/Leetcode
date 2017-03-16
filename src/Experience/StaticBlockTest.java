package Experience;

/**
 * Created by apple on 17/3/4.
 */
public class StaticBlockTest {
    public static void main(String[] args) {
        try
        {
            Class.forName("Test");
            Class.forName("Test");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
