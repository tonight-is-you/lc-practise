// 单词搜索
public class Hot79 {
    private static final int[][] ds = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    private int len;
    private int row;
    private int col;
    private boolean[][] visited;
    private char[] wordChar;
    private char[][] board;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        row = board.length;
        len = word.length();
        col = board[0].length;
        visited = new boolean[row][col];
        wordChar = word.toCharArray();
        for (int i = 0; i < row; i ++){
            for (int j = 0; i < col; j ++){
                if (dfs(i, j, 0))
                    return true;
            }
        }
        return false;
    }
    private boolean dfs(int x, int y, int begin){
        if (begin == len - 1)
            return wordChar[begin] == board[x][y];
        if (board[x][y] == wordChar[begin]){
            visited[x][y] = true;
            for (int[] d : ds){
                int newX = x + d[0];
                int newY = y + d[1];
                if (inArea(newX, newY) && !visited[newX][newY])
                    if(dfs(newX, newY, begin + 1))
                        return true;
            }
            visited[x][y] = false;
        }
        return false;
    }
    private boolean inArea(int l, int r){
        return l < row && l >= 0 && r < col && r >= 0;
    }
}
