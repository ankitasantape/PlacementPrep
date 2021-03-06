package Recursion_In_Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number x. 
4. You are required to find the all indices at which x occurs in array a.
5. Return an array of appropriate size which contains all indices at which x occurs in array a.
Input Format
A number n
n1
n2
.. n number of elements
A number x
Output Format
Return the array of indices from the allIndices function. Display is managed for you.
Sample Input
6
15
11
40
4
4
9
4
Sample Output
3
4
 */

public class All_Indices_Of_Array {
	 public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int n = Integer.parseInt(br.readLine());
	        int[] arr = new int[n];

	        for (int i = 0; i < n; i++) {
	            arr[i] = Integer.parseInt(br.readLine());
	        }
	        int x = Integer.parseInt(br.readLine());
	        int[] iarr = allIndices(arr, x, 0, 0);

	        if(iarr.length == 0){
	            System.out.println();
	            return;
	        }

	        for(int i = 0; i < iarr.length; i++){
	            System.out.println(iarr[i]);
	        }
	    }

	    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
	       if(idx == arr.length){
	           return new int[fsf];
	       } 
	       
	       if (arr[idx] == x){
	           int ans[] = allIndices(arr, x, idx + 1, fsf + 1);
	           ans[fsf] = idx;
	           return ans;
	       } else {
	           int ans[] = allIndices(arr, x, idx + 1, fsf);
	           return ans;
	       }
	    }
	
	  public static int[] allIndices2(int[] arr, int x, int idx, int fsf) {
               if(idx == arr.length){
                  return new int[fsf];
               } 
        
               if(arr[idx] == x){
                    fsf++; 
               }
               int ans[] =  allIndices(arr, x, idx + 1, fsf);
        
               if(arr[idx] == x){
                    ans[fsf - 1] = idx;
               }
                return ans;
         }
}
