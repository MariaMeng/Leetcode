package Experience;

import java.util.Scanner;

/**
 * Created by apple on 17/2/22.
 */
public class ScannerInput {
    public static void main(String[] args) {
        String str = null;
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            System.out.println("picture name : ");
            str = in.nextLine();
            System.out.println(str);
            str = null;
        }
        in.close();
    }
}
