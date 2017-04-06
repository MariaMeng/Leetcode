package Experience;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * Created by apple on 17/4/2.
 */
public class TestMainIO {
    public static void main(String[] args) throws FileNotFoundException {
        TestMainIO test_print = new TestMainIO();
        int[][] G = test_print.intputGragh("D:\\Users\\test.txt" , 6);
        int[][] Dis = test_print.floyd(G, 6);
        test_print.printG(Dis, 6);
    }

    public void printG(int[][] G,int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.println(i+"->"+j+"  "+G[i][j]);
            }
        }
    }

    public int[][] intputGragh(String path , int num) throws FileNotFoundException{
        int[][] G = new int[num][num];
        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                G[i][j]=999;
            }
        }
        Scanner in = new Scanner(new FileInputStream(path));
        while (in.hasNext()) {
            int i = in.nextInt();
            int j = in.nextInt();
            int weight = in.nextInt();
            G[i][j] = weight;
        }
        return G;
    }

    public int[][] floyd(int[][] G,int n){
        int[][] Dis= new int[n][n];
        for(int q=0;q<n;q++){
            for(int w=0;w<n;w++){
                Dis[q][w]=G[q][w];
            }
        }

        for(int k = 0; k < n; k++){
            for(int i=0; i < n; i++ ){
                for(int j=0; j < n; j++){
                    if(Dis[i][j]>Dis[i][k]+Dis[k][j]){
                        Dis[i][j]=Dis[i][k]+Dis[k][j];
                    }
                }
            }
        }
        return Dis;
    }
}
