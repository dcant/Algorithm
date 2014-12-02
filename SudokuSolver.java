package cn.edu.sjtu.zzang;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
        	return;
        solver(board, 0, 0);
    }
    
    private boolean solver(char[][] board, int i, int j) {
    	if (j >= 9)
    		return solver(board, i + 1, 0);
    	if (i == 9)
    		return true;
    	if (board[i][j] == '.') {
    		for (int k = 0; k < 9; k++) {
    			board[i][j] = (char)(k + '1');
    			if (isValid(board, i, j)) {
    				if (solver(board, i, j + 1))
    					return true;
    			}
    			board[i][j] = '.';
    		}
    	} else
    		return solver(board, i, j + 1);
    	return false;
    }
    
    private boolean isValid(char[][] board, int i, int j) {
    	for (int m = 0; m < 9; m++) {
    		if (m != j && board[i][m] == board[i][j])
    			return false;
    	}
    	
    	for (int m = 0; m < 9; m++) {
    		if (m != i && board[m][j] == board[i][j])
    			return false;
    	}

    	for (int r = i / 3 * 3; r < i / 3 * 3 + 3; r++) {
    		for (int c = j / 3 * 3; c < j / 3 * 3 + 3; c++)
    			if ((r != i || c != j) && board[r][c] == board[i][j])
    				return false;
    	}
    	
    	return true;
    }
}
