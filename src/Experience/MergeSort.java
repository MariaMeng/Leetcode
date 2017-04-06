package Experience;

/**
 * Created by apple on 17/3/24.
 */
public class MergeSort {
    public void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return ;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, right);
    }
    private void merge(int[] arr, int left, int right) {
        int[] temp = new int[right - left + 1];
        int mid = (left + right) / 2;
        int i = left, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        // 将当前的值覆盖
        for (int a = 0; a < temp.length; a++) {
            arr[left + a] = temp[a];
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[] {5, 8, 7, 5, 7, 3, 6, 2};
        MergeSort my = new MergeSort();
        my.mergeSort(arr, 0, arr.length - 1);
        for (int a : arr) {
            System.out.print(a + "\t");
        }
    }

}
