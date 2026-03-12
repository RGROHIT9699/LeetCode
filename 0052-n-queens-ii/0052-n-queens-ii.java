class Solution {
    static boolean[][] board;
    public int totalNQueens(int n) {
        if(n==1) return 1;
        board = new boolean[n][n];
        return print(n,0);        
    }
    public static int print(int tq,int row) {
		if(tq==0) return 1;
        int count=0;
		for(int col=0;col<board[0].length;col++) {
			if(isItSafe(row,col)) {
				board[row][col]=true;
				count+=print(tq-1,row+1);
				board[row][col]=false;
			}
		}
        return count;
	}
	public static boolean isItSafe(int row,int col) {
		int r= row;
		int c = col;
		while(r>=0) {
			if(board[r--][col]==true) {
				return false;
			}
		}
		r=row;
		while(r>=0 && c>=0) {
			if(board[r--][c--]==true) {
				return false;
			}	
		}
		r=row;
		c=col;
		while(r>=0 && c<board[0].length) {
			if(board[r--][c++]==true) {
				return false;
			}
		}
		return true;
	}
}