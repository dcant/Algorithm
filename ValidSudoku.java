package cn.edu.sjtu.zzang;

public class ValidSudoku {
	public static void main(String[] args) {
		char[][] board = {".87654321".toCharArray(),"2........".toCharArray(),"3........".toCharArray(),"4........".toCharArray(),"5........".toCharArray(),"6........".toCharArray(),"7........".toCharArray(),"8........".toCharArray(),"9........".toCharArray()};
		ValidSudoku vs = new ValidSudoku();
		boolean res = vs.isValidSudoku(board);
		if (res)
			System.out.println("y");
	}
	
    public boolean isValidSudoku(char[][] board) {
    	if (board == null || board.length != 9 || board[0].length != 9)
    		return false;
        for (int i = 0; i < 9; i++) {
        	boolean[] flags = new boolean[9];
        	for (int j = 0; j < 9; j++) {
        		if (board[i][j] != '.') {
        			if (flags[(int)(board[i][j] - '1')])
        				return false;
        			else
        				flags[(int)(board[i][j] - '1')] = true;
        		}
        	}
        }
        
        for (int j = 0; j < 9; j++) {
        	boolean[] flags = new boolean[9];
        	for (int i = 0; i < 9; i++) {
        		if (board[i][j] != '.') {
        			if (flags[(int)(board[i][j] - '1')])
        				return false;
        			else
        				flags[(int)(board[i][j] - '1')] = true;
        		}
        	}
        }
        
        for (int k = 0; k < 9; k++) {
        	boolean[] flags = new boolean[9];
        	for (int i = k / 3 * 3; i < k /3 * 3 + 3; i++) {
        		for (int j = k % 3 * 3; j < k % 3 * 3 + 3; j++) {
        			if (board[i][j] != '.') {
        				if (flags[(int)(board[i][j] - '1')])
        					return false;
        				else
        					flags[(int)(board[i][j] - '1')] = true;
        			}
        		}
        	}
        }
        return true;
    }
}
