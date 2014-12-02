package cn.edu.sjtu.zzang;

public class NQueensII {
	public static void main(String[] args) {
		NQueensII nq = new NQueensII();
		System.out.println(nq.totalNQueens(1));
	}

    public int totalNQueens(int n) {
        int[] place = new int[n + 1];
        place[n] = 0;
        worker(place, 0);
        return place[n];
    }
    private void worker(int[] place, int curRow) {
    	if (curRow == place.length - 1) {
    		place[place.length - 1]++;
    		return;
    	}
    	for (int i = 0; i < place.length - 1; i++) {
    		if (isValid(place, curRow, i)) {
    			place[curRow] = i;
    			worker(place, curRow + 1);
    		}
    	}
    }
    
    private boolean isValid(int[] place, int curRow, int col) {
    	for (int i = 0; i < curRow; i++) {
    		if (place[i] == col || Math.abs(place[i] - col) == Math.abs(i - curRow))
    			return false;
    	}
    	return true;
    }
}
