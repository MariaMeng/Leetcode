package Experience;

/**
 * Created by apple on 17/3/23.
 */
public class newSort {
    public void quicksort(int[] arr, int left, int right) {
        if (left < right) {
            findPivot(arr, left, right);
            int pivot = right - 1;

            int i = left;

            int j = right - 1;

            while (true) {
                while (arr[++i] < arr[pivot]);
                while (j > left && arr[--j] > arr[pivot]) ;
                if (i < j) {
                    swap(arr, i, j);
                } else {
                    break;
                }

            }
            if (i < right) {
                swap(arr, i, right - 1);
            }
            quicksort(arr, left, i - 1);
            quicksort(arr, i + 1, right);
        }
    }
    public void findPivot(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (arr[left] > arr[right])
            swap(arr, left, right);
        if (arr[mid] > arr[right])
            swap(arr, mid, right);
        if (arr[left] > arr[mid])
            swap(arr, left, mid);
        swap(arr, right - 1, mid);
    }


    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void main(String[] args) {
        //int[] arr = new int[] {2, 4, 1, 3, 5};
        int[] arr = new int[] {5, 8, 7, 5, 7, 3, 6, 2};
        newSort my = new newSort();
        int length = arr.length;
        my.quicksort(arr, 0, length - 1);
        for (int a : arr) {
            System.out.print(a + "\t");
        }
    }
}
