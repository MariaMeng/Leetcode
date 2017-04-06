/**
 * Created by apple on 17/3/23.
 */
public class sort {


    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = findPivot(arr, left, right);
            int i = left;
            int j = right - 1;
            while (true) {
                while (arr[++i] < arr[pivot]);
                while (j > left && arr[--j] > arr[pivot]);
                if (i < j)
                    swap(arr, i, j);
                else break;
            }
            if (i < right) // swap the i with the pivot
                swap(arr, i, pivot);
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }

    private int findPivot(int[] arr, int left, int right) {
        int mid = (left + right) / 2;

        if (arr[left] > arr[mid])
            swap(arr, left, mid);

        if (arr[left] > arr[right])
            swap(arr, left, right);

        if (arr[mid] > arr[right])
            swap(arr, mid, right);

        swap(arr, mid, right - 1);

        return right - 1;
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static int partition(int []array,int lo,int hi){
        //固定的切分方式
        int key=array[lo];
        while(lo<hi){
            while(array[hi]>=key&&hi>lo){//从后半部分向前扫描
                hi--;
            }
            array[lo]=array[hi];
            while(array[lo]<=key&&hi>lo){ // 从前半部分向后扫描
                lo++;
            }
            array[hi]=array[lo];
        }
        array[hi]=key;
        return hi;
    }
    public static void sort(int[] array,int lo ,int hi){
        if(lo>=hi){
            return ;
        }
        int index=partition(array,lo,hi);
        sort(array,lo,index-1);
        sort(array,index+1,hi);
    }
    public static void main(String[] args) {
        /*
        int[] array = new int[]{2, 5, 3, 4, 8, 1};
        sort(array, 0, array.length - 1);
        for (int a : array)
            System.out.print(a + "\t");
        */
        sort my = new sort();
        int[] arr = new int[] {5, 8, 7, 5, 7, 3, 6, 2};
        my.quickSort(arr, 0, arr.length - 1);
        for (int a : arr) {
            System.out.print(a + "\t");
        }
    }


}
