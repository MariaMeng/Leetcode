/**
 * Created by apple on 17/1/20.
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.
 */
public class SortColors {
    /*
        方法一： 采用Share my one pass constant space 10-line solution方法
        The idea is to sweep all 0s to the left and all 2s to the right,
        then all 1s are left in the middle.
     */
    public void sortColors(int[] nums) {
        if(nums == null || nums.length < 2) return ;
        int left = 0, right = nums.length - 1; // two pointers
        for (int i = left; i <= right;) {
            if(nums[i] == 0) {
                // swap the current with left
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                i++;
                left++;
            }
            else if(nums[i] == 2) {
                // swap the current with right
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
            }else
                i++;
        }
    }

    /*
        Bubble Sorting and its modifications
        在要排序的一组数中，对当前还未排好序的范围内的全部数，
        自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。
        即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
     */
    public void bubbleSort(int a[], int n){
        for(int i = 0 ; i < n - 1; ++i) { // control the number of iterations
            for(int j = 0; j < n - i - 1; ++j) { // in each iteration, j controls the number of elements to retrieve
                if(a[j] > a[j + 1]) {
                    int tmp = a[j] ;
                    a[j] = a[j + 1] ;
                    a[j + 1] = tmp;
                }
            }
        }
    }
    /*
        对冒泡排序常见的改进方法是加入一标志性变量exchange，用于标志某一趟排序过程中是否有数据交换，
        如果进行某一趟排序时并没有进行数据交换，则说明数据已经按要求排列好，可立即结束排序，避免不必要的比较过程。
        本文再提供以下两种改进算法：
        1．设置一标志性变量pos, 用于记录每趟排序中最后一次进行交换的位置。
           由于pos位置之后的记录均已交换到位, 故在进行下一趟排序时只要扫描到pos位置即可。
     */
    public void Bubble_1( int r[], int n) {
        int i = n - 1; // right pointers
        while (i > 0) {
            int pos = 0; //exchange position
            for (int j = 0; j < i; j++) // left pointer
                if (r[j] > r[j + 1]) {
                    pos = j; //记录交换的位置
                    int tmp = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = tmp;
                }
            i = pos; //为下一趟排序作准备
        }
    }

    /*
        2．传统冒泡排序中每一趟排序操作只能找到一个最大值或最小值,
           我们考虑利用在每趟排序中进行正向和反向两遍冒泡的方法一次可以得到两个最终值(最大者和最小者) ,
           从而使排序趟数几乎减少了一半。
     */
    public void Bubble_2 (int r[], int n){
        int low = 0, high = n - 1; // two pointers
        int tmp, j;
        while (low < high) {
            for (j = low; j < high; ++j) //正向冒泡,找到最大者
                if (r[j] > r[j + 1]) {
                    tmp = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = tmp;
                }
            --high;                 //修改high值, 前移一位
            for (j = high; j > low; --j) //反向冒泡,找到最小者
                if (r[j] < r[j - 1]) {
                    tmp = r[j];
                    r[j] = r[j - 1];
                    r[j - 1] = tmp;
                }
            ++low;                  //修改low值,后移一位
        }
    }
    public static void main(String[] args) {
        SortColors mySolution = new SortColors();
        int[] nums = {2, 2, 0, 2, 1, 2, 0, 1};
        int[] another = {1, 2, 0};
        mySolution.sortColors(another);

        for (int a : another)
            System.out.print(a + "\t");
    }

}
