package cn.edu.sjtu.zzang;

public class DungeonGame {
	public static void main(String[] args) {
		int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
		DungeonGame dg = new DungeonGame();
		System.out.println(dg.calculateMinimumHP(dungeon));
	}

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null)
        	return 1;
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] minimals = new int[row][col];

        minimals[row - 1][col - 1] = 1 > dungeon[row - 1][col - 1] ? 1 - dungeon[row - 1][col - 1] : 1;
        for (int i = row - 2; i >= 0; i--) {
        	minimals[i][col - 1] = minimals[i + 1][col - 1] > dungeon[i][col - 1] ? minimals[i + 1][col - 1] - dungeon[i][col - 1] : 1;
        }

        for (int j = col - 2; j >= 0; j--) {
        	minimals[row - 1][j] = minimals[row - 1][j + 1] > dungeon[row - 1][j] ? minimals[row - 1][j + 1] - dungeon[row - 1][j] : 1;
        }
        
        for (int i = row - 2; i >= 0; i--) {
        	for (int j = col - 2; j >= 0; j--) {
        		int down = minimals[i + 1][j] > dungeon[i][j] ? minimals[i + 1][j] - dungeon[i][j] : 1;
        		int right = minimals[i][j + 1] > dungeon[i][j] ? minimals[i][j + 1] - dungeon[i][j] : 1;
        		minimals[i][j] = down > right ? right : down;
        	}
        }
        
        return minimals[0][0];
    }
}
