/**
 * Created by apple on 17/2/8.
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell,
 where "adjacent" cells are those horizontally or vertically neighboring.
 The same letter cell may not be used more than once.

 For example,
 Given board =
 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 注意事项：两个counter维护当前的横纵位置；
          同一个letter不能使用两次--> bit mask。
          原始exist函数->遍历头节点位置： x, 纵坐标（列）；y, 横坐标(行)。
          backtrack进行DFS搜索，从当前位置往右，往左，往上，往下四个方向。
 问题1：为什么选择256而不选择1来作为bit mask呢？
 答案：ascii及其扩展一共有256个字符从0-255，因此采用256(二进制1 0000 0000)能很好地完成这个标记功能.

 问题2：x < 0, y < 0 这又是什么情况？
 答案： x < 0, board中左侧越界； y < 0, board中上侧越界。
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[y].length; x++) {
                if (backtrack(board, y, x, w, 0)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;
        board[y][x] ^= 256; // 用来盖住这个字符，表示已被占用。
        boolean exist = backtrack(board, y, x+1, word, i+1)
                || backtrack(board, y, x-1, word, i+1)
                || backtrack(board, y+1, x, word, i+1)
                || backtrack(board, y-1, x, word, i+1);
        board[y][x] ^= 256;
        return exist;
    }
    public static void main(String[] args) {

    }
}
