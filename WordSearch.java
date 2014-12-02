package cn.edu.sjtu.zzang;

public class WordSearch {
	public static void main(String[] args) {
		WordSearch ws = new WordSearch();
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		System.out.println(ws.exist(board, "ABCCED"));
		System.out.println(ws.exist(board, "SEE"));
		System.out.println(ws.exist(board, "ABCB"));
	}

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[0].length; j++) {
        		if (search(board, visited, word, 0, i, j))
        			return true;
        	}
        }
        return false;
    }
    
    private boolean search(char[][] board, boolean[][] visited, String word, int n, int i, int j) {
    	if (n == word.length())
    		return true;
    	else if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
    		return false;
    	else if (visited[i][j])
    		return false;
    	else if (word.charAt(n) != board[i][j])
    		return false;
    	else {
    		visited[i][j] = true;
    		boolean res = search(board, visited, word, n + 1, i - 1, j) || search(board, visited, word, n + 1, i + 1, j)
    				|| search(board, visited, word, n + 1, i, j - 1) || search(board, visited, word, n + 1, i, j + 1);
    		visited[i][j] = false;
    		return res;
    	}
    }
}
