/*
1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the combinations in which n queens can be placed on the 
     n * n chess-board. 
3. No queen shall be able to kill another.

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
               force you but the intention is to teach a concept. Play in spirit of the question.
Input Format
A number n
Output Format
Check the sample output and question video
Constraints
1 <= n <= 5
Sample Input
4
Sample Output
-	q	-	-	
-	-	-	q	
q	-	-	-	
-	-	q	-	

-	-	q	-	
q	-	-	-	
-	-	-	q	
-	q	-	-	
*/
package Recursion_Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A10_N_Queens_Cominations_2dAs1d_Queen_Chooses {
	public static boolean IsQueenSafe(boolean[][] chess, int row, int col) {
		for (int i = row, j = col; i >= 0; i--) {
			if (chess[i][j] == true) {
				return false;
			}
		}

		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (chess[i][j] == true) {
				return false;
			}
		}
//			top-right
		for (int i = row, j = col; i >= 0 && j < chess.length; i--, j++) {
			if (chess[i][j] == true) {
				return false;
			}
		}
		for (int i = row, j = col; j >= 0; j--) {
			if (chess[i][j] == true) {
				return false;
			}
		}
		return true;
	}

	public static void nqueens(int qpsf, int tq, boolean[][] chess, int lcno) {
		if (qpsf == tq) {
			for (int row = 0; row < chess.length; row++) {
				for (int col = 0; col < chess.length; col++) {
					System.out.print(chess[row][col] ? "q\t" : "-\t");
				}
				System.out.println();
			}
			System.out.println();
			return;
		}

		for (int i = lcno + 1; i < chess.length * chess.length; i++) {
			int row = i / chess.length;
			int col = i % chess.length;

			if (chess[row][col] == false && IsQueenSafe(chess, row, col)) {
				chess[row][col] = true;
				nqueens(qpsf + 1, tq, chess, row * chess.length + col);
				chess[row][col] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[][] chess = new boolean[n][n];

		nqueens(0, n, chess, -1);
	}
}
