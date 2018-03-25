package Experience.Sorting.ExchangeSorting;

/**
 * Created by maria on 17-11-9.
 */
public class Bubble {
    public static void bubble(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int score[] = {67, 69, 75, 87, 89, 90, 99, 100};
        bubble(score);
        for (int a : score) {
            System.out.print(a + " ");
        }
    }
}
