/*
1. You are given an array of integers.
2. You have to find the XOR of sum of all pairs in the array.
Input Format
A number N
arr1
arr2..
N numbers
Output Format
Check the sample ouput and question video.
Constraints
1 <= N <= 10^9
1 <= arr[i] <= 10^9
Sample Input
5
1
5
2
1
2
Sample Output
10
*/
package Bit_Manipulation;

import java.util.Scanner;

public class A13_Xor_Of_Sum_Of_All_Pairs {
  
	public static int solution(int[] arr) {
		int ans = 0;
		for(int val : arr) {
			ans = ans ^ (2 * val);
		}

		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}
	    
}
