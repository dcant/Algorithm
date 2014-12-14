package cn.edu.sjtu.zzang;

import java.util.LinkedList;

public class SurroundedRegions {
	public static void main(String[] args) {
		SurroundedRegions sr = new SurroundedRegions();
//		char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		char[][] board = new char[5][5];
		board[0] = new String("OXXOX").toCharArray();
		board[1] = new String("XOOXO").toCharArray();
		board[2] = new String("XOXOX").toCharArray();
		board[3] = new String("OXOOO").toCharArray();
		board[4] = new String("XXOXO").toCharArray();
		sr.solve(board);
		for (char[] row : board) {
			for (char c : row)
				System.out.print(c + " ");
			System.out.println();
		}
	}
	public void solve(char[][] board) {
	    if(board==null || board.length<=1 || board[0].length<=1)
	        return;
	    for(int i=0;i<board[0].length;i++)
	    {
	        fill(board,0,i);
	        fill(board,board.length-1,i);
	    }
	    for(int i=0;i<board.length;i++)
	    {
	        fill(board,i,0);
	        fill(board,i,board[0].length-1);
	    }
	    for(int i=0;i<board.length;i++)
	    {
	        for(int j=0;j<board[0].length;j++)
	        {
	            if(board[i][j]=='O')
	                board[i][j]='X';
	            else if(board[i][j]=='#')
	                board[i][j]='O';                
	        }
	    }
	}

	// recursive dfs version will stackoverflow
	private void fill(char[][] board, int i, int j)
	{
	    if(board[i][j]!='O')
	        return;
	    board[i][j] = '#';
	    LinkedList<Integer> queue = new LinkedList<Integer>();
	    int code = i*board[0].length+j;
	    queue.offer(code);
	    while(!queue.isEmpty())
	    {
	        code = queue.poll();
	        int row = code/board[0].length;
	        int col = code%board[0].length;
	        if(row>0 && board[row-1][col]=='O')
	        {
	            queue.offer((row-1)*board[0].length+col);
	            board[row-1][col]='#';
	        }
	        if(row<board.length-1 && board[row+1][col]=='O')
	        {
	            queue.offer((row+1)*board[0].length+col);
	            board[row+1][col]='#';
	        }
	        if(col>0 && board[row][col-1]=='O')
	        {
	            queue.offer(row*board[0].length+col-1);
	            board[row][col-1]='#';
	        }
	        if(col<board[0].length-1 && board[row][col+1]=='O')
	        {
	            queue.offer(row*board[0].length+col+1);
	            board[row][col+1]='#';
	        }            
	    }
	}
}