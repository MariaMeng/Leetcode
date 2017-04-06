package Experience.ACMBUPT;
import java.util.*;
/**
 * Created by apple on 17/4/3.
 */
public class ChangeLetters {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        if(T>5)
            return;
        while(T--!=0)
        {
            in.nextLine();
            char ch1[] = in.nextLine().trim().toLowerCase().toCharArray();
            char ch2[] = in.nextLine().trim().toLowerCase().toCharArray();
            int n = in.nextInt();
            int [][]matrix = new int[26][26];
            for(int i=0;i<26;i++) {
                for(int j=0;j<26;j++)
                    matrix[i][j] = Integer.MAX_VALUE;
            }

            for(int i=0;i<n;i++) {
                int temp1 = in.next().toCharArray()[0] - 'a';
                int temp2 = in.next().toCharArray()[0] - 'a';
                int temp3 = in.nextInt();
                if(temp3>0&&temp3<=100) {
                    matrix[temp1][temp2] = Math.min(temp3, matrix[temp1][temp2]);
                    matrix[temp2][temp1] = Math.min(temp3, matrix[temp2][temp1]);
                }
            }
            int len = ch1.length;
            if(len==0&&ch2.length==0) {
                System.out.println(0);
                continue;
            }
            if(ch1.length!=ch2.length||ch1.length>100000) {
                System.out.println(-1);
                continue;
            }
            int [][]dist = new int[26][26];
            int [][]path = new int[26][26];

            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    dist[i][j] = matrix[i][j];
                    path[i][j] = j;
                }
            }
            // 计算最短路径
            for (int k = 0; k < 26; k++) {
                for (int i = 0; i < 26; i++) {
                    for (int j = 0; j < 26; j++) {
                        int tmp = (dist[i][k]==Integer.MAX_VALUE || dist[k][j]==Integer.MAX_VALUE) ? Integer.MAX_VALUE : (dist[i][k] + dist[k][j]);
                        if (dist[i][j] > tmp) {
                            dist[i][j] = tmp;
                            path[i][j] = path[i][k];
                        }
                    }
                }
            }
            int sum = 0;
            for(int i=0;i<len;i++)
            {
                if(ch1[i]!=ch2[i])
                {
                    if(dist[ch1[i]-'a'][ch2[i]-'a']!=Integer.MAX_VALUE)
                        sum+=dist[ch1[i]-'a'][ch2[i]-'a'];
                    else {
                        sum = -1;
                        break;
                    }
                }
            }
            System.out.println(sum);
        }
    }
}
