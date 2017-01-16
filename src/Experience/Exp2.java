package Experience;

import java.util.HashMap;
import java.util.Random;

public class Exp2 {
    public static void main(String[] args) {
        HashMap h2 = new HashMap();
        for (int i = 0; i < 10; i++) {
            h2.put(new Element(i), new Figureout());
            System.out.println("h2:");
            System.out.println("Get the result for Element:");
        }
        Element test = new Element(3);
        if (h2.containsKey(test)) {
            System.out.println((Figureout) h2.get(test));
        } else {
            System.out.println("Not found");
        }
    }
}

class Element {
    int number;

    public Element(int n) {
        number = n;
    }
}

class Figureout {
    Random r = new Random();
    boolean possible = r.nextDouble() > 0.5;

    public String toString() {
        if (possible) {
            return "OK!";
        } else {
            return "Impossible!";
        }
    }
}
