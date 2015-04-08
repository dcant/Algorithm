package cn.edu.sjtu.zzang;

public class NumberOfIslands {
	public static void main(String[] args) {
		NumberOfIslands no = new NumberOfIslands();
		char[][] grid = {{'1','1','1','1','0'},{'1','0','1','1','0'},{'0','1','1','0','1'},{'0','0','0','1','0'}};
		System.out.println(no.numIslands(grid));
	}
	
    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0)
        	return 0;
        int row = grid.length;
        int col = grid[0].length;
        
        for (int i = 0; i < row; i++) {
        	for (int j = 0; j < col; j++) {
        		if (grid[i][j] == '1') {
        			dfs(grid, i, j);
        			res++;
        		}
        	}
        }
        return res;
    }
    
    private void dfs(char[][] grid, int x, int y) {
    	if (x < 0 || x >= grid.length)
    		return;
    	if (y < 0 || y >= grid[0].length)
    		return;
    	if (grid[x][y] != '1')
    		return;
    	grid[x][y] = 'X';
    	dfs(grid, x + 1, y);
    	dfs(grid, x - 1, y);
    	dfs(grid, x, y + 1);
    	dfs(grid, x, y - 1);
    }
}
