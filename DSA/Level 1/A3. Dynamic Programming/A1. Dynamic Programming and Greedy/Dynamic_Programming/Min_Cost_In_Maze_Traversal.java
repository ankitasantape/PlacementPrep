package Dynamic_Programming;

import java.util.Scanner;

/*
 1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a maze.
4. You are standing in top-left cell and are required to move to bottom-right cell.
5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
6. Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom- 
     right cell).
7. You are required to traverse through the matrix and print the cost of path which is least costly.
Input Format
A number n
A number m
e11
e12..
e21
e22..
.. n * m number of elements
Output Format
The cost of least costly path.
Sample Input
6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1
Sample Output
23

Sample Input:
5
5
2 8 4 1 6
6 0 9 5 3
1 4 3 4 0
6 4 7 2 4
1 0 3 7 1
Sample Output:
24 24 18 14 14 
22 16 21 13 8 
17 16 12 9 5 
18 15 14 7 5 
12 11 11 8 1 
24
 */
public class Min_Cost_In_Maze_Traversal {
      
	 public static void main(String[] args) throws Exception {
		 Scanner sc= new Scanner(System.in);
         int n = sc.nextInt();
         int m = sc.nextInt();
         int a[][] = new int[n][m];
         for(int i = 0; i < n; i++) {
        	 for(int j = 0; j < m; j++) {
        		 a[i][j] = sc.nextInt();
        	 }
         }
         System.out.println(min_cost_in_maze_traversal(a, n, m));
         sc.close();  
	 }

	private static int min_cost_in_maze_traversal(int[][] a, int n, int m) {
		 
		int dp[][] = new int[n][m];
		
		for(int i = n-1; i >= 0; i--) {
			for(int j = m-1; j >= 0; j--) {
				if(i == n-1 && j == m-1) {
					dp[i][j] = a[i][j];
				} else if(j == m-1) {
					dp[i][j] = dp[i + 1][j] +a[i][j];
				} else if(i == n-1) {
					dp[i][j] = dp[i][j + 1] + a[i][j];
				} else {
					dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + a[i][j];
				}
			}
		}
		
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < m; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		return dp[0][0];
	}
}
