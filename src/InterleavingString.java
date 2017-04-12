import java.util.Scanner;

/**
 * Created by apple on 17/4/11.
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

 For example,
 Given:
 s1 = "aabcc",
 s2 = "dbbca",

 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) return false;
        return DFS(c1, c2, c3, 0, 0, 0, new boolean[m + 1][n + 1]);
    }
    private boolean DFS(char[] c1, char[] c2, char[] c3, int i, int j, int k, boolean[][] invalid) {
        if (invalid[i][j]) return false;
        if (k == c3.length) return true;
        boolean valid = i < c1.length && c1[i] == c3[k] && DFS(c1, c2, c3, i + 1, j, k + 1, invalid) ||
                j < c2.length && c2[j] == c3[k] && DFS(c1, c2, c3, i, j + 1, k + 1, invalid);
        if (!valid) invalid[i][j] = true;
        return valid;
    }
    public static void main(String[] args) {
        InterleavingString my = new InterleavingString();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s1 = in.next();
            String s2 = in.next();
            String s3 = in.next();
            System.out.println(my.isInterleave(s1, s2, s3));
        }
    }

}
