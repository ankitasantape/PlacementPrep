package Time_And_Space_Complexity;

import java.util.Scanner;

/*
1. You are given an array(arr) of integers.
2. You have to sort the given array in increasing order using insertion sort.
Sample Input
5
7 
-2 
4 
1 
3
Sample Output
Comparing -2 and 7
Swapping 7 and -2
Comparing 4 and 7
Swapping 7 and 4
Comparing 4 and -2
Comparing 1 and 7
Swapping 7 and 1
Comparing 1 and 4
Swapping 4 and 1
Comparing 1 and -2
Comparing 3 and 7
Swapping 7 and 3
Comparing 3 and 4
Swapping 4 and 3
Comparing 3 and 1
-2
1
3
4
7
 */

public class Insertion_Sort {
   
	public static void insertionSort(int[] arr) {
		  int n = arr.length; 
          for(int i = 1; i < n; i++) {
        	  for(int j = i-1; j >= 0; j--) {
        		  if( isGreater(arr, j, j+1 )) {
        			  swap(arr, j, j+1);
        		  } else {
        			  break;
        		  }
        	  }
          }
	}

	// used for swapping ith and jth elements of array
	public static void swap(int[] arr, int i, int j) {
		System.out.println("Swapping " + arr[i] + " and " + arr[j]);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// return true if jth element is greater than ith element
	public static boolean isGreater(int[] arr, int j, int i) {
		System.out.println("Comparing " + arr[i] + " and " + arr[j]);
		if (arr[i] < arr[j]) {
			return true;
		} else {
			return false;
		}
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		insertionSort(arr);
		print(arr);
		scn.close();
	}

}
