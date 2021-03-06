package Dynamic_Programming_Category4;

import java.util.Scanner;

/*
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are given a number k, representing the number of transactions allowed.
3. You are required to print the maximum profit you can make if you are allowed k transactions at-most.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
Input Format
A number n
.. n more elements
A number k
Output Format
A number representing the maximum profit you can make if you are allowed a single transaction.
Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 10
0 <= k <= n / 2
Sample Input
6
9
6
7
6
3
8
1
Sample Output
5

Sample Input :
10
9 6 4 8 12 3 7 2 5 9
3
dp [ 0 0 0 0 0 0 0 0 0 0 
     0 0 0 4 8 8 8 8 8 8 
     0 0 0 4 8 8 12 12 12 15 
     0 0 0 4 8 8 12 12 15 19 ]
Sample Output:
19
*/
public class Buy_And_Sell_Stocks_K_Transaction_Allowed {
      
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		System.out.println(buy_and_sell_K_transaction(n, arr, k));
		System.out.println(k_transactions_Allowed_2(n, arr, k));
		System.out.println(k_transactions_Allowed_Optimized(n, arr, k));
		sc.close();
	}
//	Time complexity - O(n*k)
	private static int k_transactions_Allowed_Optimized(int n, int[] arr, int k) {
        int dp[][] = new int[k+1][n];
        for (int t = 1; t <= k; t++){
            int max = Integer.MIN_VALUE;
            for(int d = 1; d < n; d++){
                
                max = Math.max( max, dp[t-1][d-1] - arr[d-1]);
                
                dp[t][d] = Math.max( dp[t][d-1] , max + arr[d] );
                
            }
        }
        
        return dp[k][n-1];
  }
	
//      Time Complexity - O(n^2*k)
	private static int buy_and_sell_K_transaction(int n, int[] arr, int k) {
		
		int dp[][] = new int[k+1][n];
//		transaction
		for(int i = 1; i <= k; i++) {
			for (int j = 1; j < n; j++) {
//				no transaction
				int max = dp[i][j-1];
				for(int c = j-1; c >= 0; c--) {
//					transaction
					max = Math.max(max, arr[j] - arr[c] + dp[i-1][c]);
				}
				dp[i][j] = max;
			}
		}
		return dp[k][n-1];
	}
//  Time Complexity - O(n^2*k)
	private static int k_transactions_Allowed_2(int n, int[] arr, int k) {
        int dp[][] = new int[k+1][n];
        for (int t = 1; t <= k; t++){
            for(int d = 1; d < n; d++){
                int max = dp[t][d - 1];
                for(int c = 0; c < d; c++){
                    max = Math.max(max, dp[t-1][c] + arr[d] - arr[c]);
                }
                dp[t][d] = max;
            }
        }
        
        return dp[k][n-1];
  }
}
