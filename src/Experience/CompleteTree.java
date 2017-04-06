package Experience;
import java.util.*;
/**
 * Created by apple on 17/4/4.
 * 对于一棵满二叉排序树深度为k, 节点数为2 ^ k - 1, 节点值为1至2^k - 1.给出k和任意三个节点的值，
 * 输出包含该三个节点的最小子树的根节点值
 * 输入 4，10，15，13
 * 输出 12
 *
 */
public class CompleteTree {
    public static void main(String[] args){
        Scanner in  = new Scanner(System.in);
        while(in.hasNext())
        {
            int k = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
            min = Math.min(a,b);
            min = Math.min(min,c);
            max = Math.max(a,b);
            max = Math.max(max,c);
            if(min==max) { // 如果min == max三个数完全一样
                System.out.println(min);
                continue;
            }
            if(k==0){ // 如果k的深度为0， 则返回0
                System.out.println(0);
                continue;
            }
            System.out.println(helper(max, min, 1 << (k), 0));
        }
    }
    public static int helper(int max,int min,int n,int offset)
    {
        int mid = n/2+offset;
        if(mid<min)
            return helper(max,min,n/2,offset+n/2);
        else if(mid>max)
            return helper(max,min,n/2,offset);
        else
            return mid;
    }

}
