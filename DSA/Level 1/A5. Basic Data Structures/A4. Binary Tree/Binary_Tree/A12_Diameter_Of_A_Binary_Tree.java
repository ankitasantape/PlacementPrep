/*
1. You are given a partially written BinaryTree class.
2. You are required to complete the body of diameter1 function. The function is expected to return the number of edges between two nodes which are farthest from each other in terms of edges.
3. Input and Output is managed for you. 
Sample Input
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
Sample Output
6
 */
package Binary_Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class A12_Diameter_Of_A_Binary_Tree {
	public static class Node {
	    int data;
	    Node left;
	    Node right;

	    Node(int data, Node left, Node right) {
	      this.data = data;
	      this.left = left;
	      this.right = right;
	    }
	  }

	  public static class Pair {
	    Node node;
	    int state;

	    Pair(Node node, int state) {
	      this.node = node;
	      this.state = state;
	    }
	  }

	  public static Node construct(Integer[] arr) {
	    Node root = new Node(arr[0], null, null);
	    Pair rtp = new Pair(root, 1);

	    Stack<Pair> st = new Stack<>();
	    st.push(rtp);

	    int idx = 0;
	    while (st.size() > 0) {
	      Pair top = st.peek();
	      if (top.state == 1) {
	        idx++;
	        if (arr[idx] != null) {
	          top.node.left = new Node(arr[idx], null, null);
	          Pair lp = new Pair(top.node.left, 1);
	          st.push(lp);
	        } else {
	          top.node.left = null;
	        }

	        top.state++;
	      } else if (top.state == 2) {
	        idx++;
	        if (arr[idx] != null) {
	          top.node.right = new Node(arr[idx], null, null);
	          Pair rp = new Pair(top.node.right, 1);
	          st.push(rp);
	        } else {
	          top.node.right = null;
	        }

	        top.state++;
	      } else {
	        st.pop();
	      }
	    }

	    return root;
	  }

	  public static void display(Node node) {
	    if (node == null) {
	      return;
	    }

	    String str = "";
	    str += node.left == null ? "." : node.left.data + "";
	    str += " <- " + node.data + " -> ";
	    str += node.right == null ? "." : node.right.data + "";
	    System.out.println(str);

	    display(node.left);
	    display(node.right);
	  }

	  public static int height(Node node) {
	    if (node == null) {
	      return -1;
	    }

	    int lh = height(node.left);
	    int rh = height(node.right);

	    int th = Math.max(lh, rh) + 1;
	    return th;
	  }
//      Approach 1
//	  public static int diameter1(Node node) {
//	      if (node == null) {
//	    	  return 0;
//	      }
//	      int maxht = height(node.left) + height(node.right) + 2;
//	      int dia = Math.max(diameter1(node.left), diameter1(node.right));
//	      return Math.max(maxht, dia);
//	  }
//  Approach 2
  public static class DPair {
      public int ht;
      public int dia;
  }

  public static DPair diameter(Node node) {
     
     if (node == null){
         DPair pp = new DPair(); 
         pp.ht = -1;
         pp.dia = 0;
         return pp;
     }    
     
     DPair lp = diameter(node.left);
     DPair rp = diameter(node.right);
     DPair mp = new DPair();
     mp.ht = Math.max(lp.ht, rp.ht) + 1;
     mp.dia = Math.max(lp.ht + rp.ht + 2, Math.max(lp.dia, rp.dia ));
     return mp;
     
  }
  
  public static int diameter1(Node node){
      DPair pp = diameter(node);
      return pp.dia;
  }

	  public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    Integer[] arr = new Integer[n];
	    String[] values = br.readLine().split(" ");
	    for (int i = 0; i < n; i++) {
	      if (values[i].equals("n") == false) {
	        arr[i] = Integer.parseInt(values[i]);
	      } else {
	        arr[i] = null;
	      }
	    }

	    Node root = construct(arr);

	    int diameter = 0;
	    diameter = diameter1(root);
	    System.out.println(diameter);
	  }

}
