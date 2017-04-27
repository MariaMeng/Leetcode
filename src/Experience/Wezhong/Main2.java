package Experience.Wezhong;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by apple on 17/4/25.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> length = new HashMap<>();
        int flag = 0;
        int[][] data = new int[4][4];
        while (in.hasNext()) {
            length.clear();
            flag = 0;
            map.clear();
            for (int i = 0; i < 4; i++) {
                String[] str = in.nextLine().split(" ");
                for (int j = 0; j < 4; j++) {
                    data[i][j] = Integer.parseInt(str[j]);
                    if(map.containsKey(data[i][j])) {
                        map.put(data[i][j], map.get(data[i][j]) + 1);
                    } else
                        map.put(data[i][j], 1);
                }

                if (data[i][0] != data[i][2] && data[i][1] != data[i][3]) {
                    flag = 1;
                }
                if (data[i][0] == data[i][2] && data[i][1] == data[i][3]) {
                    flag = 1;
                }
                if (data[i][0] == data[i][2]) {
                    //length.put(i, Math.abs(data[i][3] - data[i][1]));
                    if (!length.containsKey(Math.abs(data[i][3] - data[i][1]))) {
                        length.put(Math.abs(data[i][3] - data[i][1]), 1);
                    } else
                        length.put(Math.abs(data[i][3] - data[i][1]),length.get(Math.abs(data[i][3] - data[i][1])) + 1);
                }
                if (data[i][1] == data[i][3]) {
                    //length.put(i, Math.abs(data[i][2] - data[i][0]));
                    if (!length.containsKey(Math.abs(data[i][2] - data[i][0]))) {
                        length.put(Math.abs(data[i][2] - data[i][0]), 1);
                    } else
                        length.put(Math.abs(data[i][2] - data[i][0]), length.get(Math.abs(data[i][2] - data[i][0])) + 1);
                }
            }
            for (int key : length.keySet()) {
                if (length.get(key) % 2 != 0)
                    flag = 1;
            }
            if (length.size() != 1 && length.size() != 2)
                flag = 1;

            int area = 1;
            if (length.size() == 1) {
                for (int key : length.keySet()) {
                    area = key;
                }
                area = area * area;
            } else if (length.size() == 2) {
                for (int key : length.keySet()) {
                    area *= key;
                }
            }

            if (area == 0) flag = 1;

            for (int key : map.keySet()) {
                if (map.get(key) % 4 != 0) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 1) {
                System.out.println("NO");
            } else
                System.out.println("YES");
        }
    }
}
