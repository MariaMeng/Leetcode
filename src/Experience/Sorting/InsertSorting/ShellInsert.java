package Experience.Sorting.InsertSorting;

/**
 * Created by maria on 17-11-9.
 */
public class ShellInsert {

    /**
     *  Shell Sorting
     *  參考連接： http://blog.csdn.net/apei830/article/details/6591509
     * @param data
     */
    public static void shellSort(int[] data) {
        // 计算出最大的h值
        int h = 1;
        // 對data驚醒分割
        while (h <= data.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            // for each iteration
            for (int i = h; i < data.length; i += h) {
                if (data[i] < data[i - h]) {
                    int tmp = data[i];
                    int j = i - h;
                    while (j >= 0 && data[j] > tmp) {
                        data[j + h] = data[j];
                        j -= h;
                    }
                    data[j + h] = tmp;
                    // output the data
                }
            }
            // 计算出下一个h值
            h = (h - 1) / 3;
        }
    }
}
