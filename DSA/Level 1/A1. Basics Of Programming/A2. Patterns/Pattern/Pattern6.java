package Pattern;

import java.util.Scanner;

public class Pattern6 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int stars = n/2 + 1, spaces = 1;
        
        for(int i = 1; i <= n; i++) {
        	for(int j = 1; j <= stars; j++) {
        		System.out.print("*\t");
        	}
        	for(int j = 1; j <= spaces; j++) {
        		System.out.print("\t");
        	}
        	for(int j = 1; j <= stars; j++) {
        		System.out.print("*\t");
        	}
//        	System.out.println(stars + "" + spaces +"" + stars);
        	if (i <= n/2) {
        	
        		stars--;
				spaces += 2;
				
			}else {
				stars++;
				spaces -= 2;
				
			}
        	System.out.println();
        }
        scn.close();
	}

}
