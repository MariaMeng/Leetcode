package Experience.ACMBUPT;
import java.util.Scanner;

/**
 * Created by LQL on 2017/4/2.
 * 题目描述:fabnacci变体
 r_clover shows you a BIIIIIIIIIIG water problem:
 if f(0)=1,f(1)=1,f(i)=2∗f(i−1)+3∗f(i−2)(i≥2), what is f(n)mod1000000007?

 输入格式
 A single integer n(0≤n≤10000000000).

 输出格式
 A single integer, which is the answer for f(n)mod1000000007.

 输入样例
 10
 输出样例
 29525
 */
public class SimpleRecursion {

    class Matrix{

        public long m00;
        public long m01;
        public long m10;
        public long m11;

        public Matrix(int m00,int m01,int m10,int m11){
            this.m00 = m00;
            this.m01 = m01;
            this.m10 = m10;
            this.m11 = m11;
        }
    }

    public Matrix mutiple(Matrix matrix1 , Matrix matrix2){
        Matrix matrix = new Matrix(2,3,1,0);
        matrix.m00 = (matrix1.m00 * matrix2.m00 + matrix1.m01 * matrix2.m10) % 1000000007;
        matrix.m01 = (matrix1.m00 * matrix2.m01 + matrix1.m01 * matrix2.m11) % 1000000007;
        matrix.m10 = (matrix1.m10 * matrix2.m00 + matrix1.m11 * matrix2.m10) % 1000000007;
        matrix.m11 = (matrix1.m10 * matrix2.m01 + matrix1.m11 * matrix2.m11) % 1000000007;
        return matrix;
    }

    public Matrix martrixPow(long n){
        Matrix matrix = null;
        if (n == 1){
            return new Matrix(2,3,1,0);
        }
        else if ((n & 1) == 0){ // if the n is even
            matrix = martrixPow(n >> 1);
            matrix = mutiple(matrix,matrix);
        }else if ((n & 1) == 1){ // if the n is odd
            matrix = martrixPow((n - 1) >> 1);
            matrix = mutiple(matrix,matrix);
            matrix = mutiple(matrix,new Matrix(2,3,1,0));
        }
        return matrix;
    }
    public long simpleRec(long n){
        if (n <= 1) return 1;
        Matrix matrix = martrixPow(n - 1);
        return (matrix.m00 * 1 + matrix.m01 * 1) % 1000000007;
    }

    public static void main(String[] args) {
        SimpleRecursion simpleRecursion = new SimpleRecursion();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        long n = Long.parseLong(s);
        long res = simpleRecursion.simpleRec(n);
        System.out.println(res);
    }

}
