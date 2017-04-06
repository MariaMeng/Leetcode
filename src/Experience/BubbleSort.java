package Experience;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 17/3/24.
 */
public class BubbleSort {
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; i < arr.length - 1 - j; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        BubbleSort my = new BubbleSort();
        int[] arr = new int[] {5, 8, 7, 5, 7, 3, 6, 2};
        my.bubbleSort(arr);
        for (int a : arr)
            System.out.print(a + "\t");

        double a = 25.64;
        int b = 25;
        a = a % 10;
        b = b % 10;
        System.out.println(a);
        String str = "aaa";
        try {

            System.out.println(str);
        } catch(Exception e) {
            System.out.println(e);
        }
        changeString(str);
        System.out.println(str);
        str = "new !!!!";
        System.out.println(str);
        List<Integer> list = new ArrayList<>();
        chageList(list);
        System.out.println(list.size());
    }
    public static void changeString(String str) {
        str = "balabala";
    }
    public static void chageList(List<Integer> list) {
        for (int i  = 0; i <= 5; i++)
            list.add(i);
    }

}
