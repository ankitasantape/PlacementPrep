/*
1. You are given n space separated strings, which represents a dictionary of words.
2. You are given another string which represents a sentence.
3. You have to print all possible sentences from the string, such that words of the sentence are 
     present in dictionary.

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A number n 
n strings representing words
a string representing a sentence
Output Format

Constraints
1 <= number of words <= 10
1 <= length of each word <= 15
1 <= length of sentence <= 1000
Sample Input
11
i like pep coding pepper eating mango man go in pepcoding
ilikepeppereatingmangoinpepcoding
Sample Output
i like pepper eating man go in pep coding 
i like pepper eating man go in pepcoding 
i like pepper eating mango in pep coding 
i like pepper eating mango in pepcoding 

*/

package Recursion_Backtracking;

import java.util.HashSet;
import java.util.Scanner;

public class A41_Work_Break_1 {
     
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashSet<String> dict = new HashSet<>();
		for(int i = 0  ; i  < n; i++){
			dict.add(scn.next());
		}
		String sentence = scn.next();
		wordBreak(sentence,"", dict);
		scn.close();
	}

	public static void wordBreak(String str, String ans, HashSet<String> dict){
		if(str.length() == 0 ) {
			System.out.println(ans);
			return;
		}
		for(int i = 0; i < str.length(); i++) {
			String left = str.substring(0, i + 1);
			if(dict.contains(left) ) {
				String right = str.substring(i + 1);
				
				wordBreak(right, ans + left + " ", dict);
				
			}
		}
	}
} 
