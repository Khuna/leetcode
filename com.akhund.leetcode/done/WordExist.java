package done;

public class WordExist {
    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        String word = "ABCCED";

        System.out.println(exist(board, word));

    }

    public static boolean exist(char[][] board, String word) {
        char[] wordChars = word.toCharArray();
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean result = finded(board, i, j, n, m, wordChars, 0);
                if (result)
                    return true;
            }
        }

        return false;
    }

    public static boolean finded(char[][] board, int k, int l, int n, int m, char[] word, int pos) {
        if (word.length <= pos)
            return true;

        if (k < 0 || k >= n || l < 0 || l >= m || board[k][l] != word[pos])
            return false;

        char c = board[k][l];
        board[k][l] = '*';

        boolean result = finded(board, k - 1, l, n, m, word, pos + 1) ||
                finded(board, k + 1, l, n, m, word, pos + 1) ||
                finded(board, k, l + 1, n, m, word, pos + 1) ||
                finded(board, k, l - 1, n, m, word, pos + 1);

        board[k][l] = c;

        return result;
    }
}

