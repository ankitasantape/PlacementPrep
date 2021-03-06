/*
1. You are required to complete the code of our Hashmap class. Please watch the question video carefully. The theoretical details of required functionality is explained in detail there. Implement the functions to achieve what is explained in the theoretical discussion in question video.
2. Input and Output is managed for you.
 
Sample Input
put India 135
put Aus 5
put Canada 3
display
get China
remove Aus
get Aus
containsKey US
put US 10
put UK 20
remove US
containsKey US
put Pak 80
put China 200
display
put Utopia 0
display
put Nigeria 3
display
put India 138
display
put Sweden 1
display
put finland 20
display
quit
Sample Output
Display Begins
Bucket0 .
Bucket1 .
Bucket2 Canada@3 .
Bucket3 India@135 Aus@5 .
Display Ends
null
5
null
false
10
false
Display Begins
Bucket0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@135 China@200 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@135 China@200 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@135 China@200 Nigeria@3 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@138 China@200 Nigeria@3 .
Display Ends
Display Begins
Bucket0 Utopia@0 Sweden@1 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@138 China@200 Nigeria@3 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Pak@80 finland@20 .
Bucket3 .
Bucket4 Sweden@1 .
Bucket5 .
Bucket6 Canada@3 UK@20 .
Bucket7 India@138 China@200 Nigeria@3 .
Display Ends 

*/

package HashMap_And_Heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class A10_Write_HashMap {
   
	public static class HashMap<K, V> {
	    private class HMNode {
	      K key;
	      V value;

	      HMNode(K key, V value) {
	        this.key = key;
	        this.value = value;
	      }
	    }

	    private int size; // n
	    private LinkedList<HMNode>[] buckets; // N = buckets.length

	    public HashMap() {
	      initbuckets(4);
	      size = 0;
	    }

	    private void initbuckets(int N) {
	      buckets = new LinkedList[N];
	      for (int bi = 0; bi < buckets.length; bi++) {
	        buckets[bi] = new LinkedList<>();
	      }
	    }

	    public void put(K key, V value) {
	       int bi = hashFunction(key);
	       int di = findWithInBucket(key, bi);
	       if(di == -1) {
//	    	   key doesn't exist in the map
	    	   buckets[bi].add(new HMNode(key, value));
	    	   size++;
	       } else {
	    	   buckets[bi].get(di).value = value;
	       }
	       double lambda = (double)size / (double)buckets.length;
	       if( lambda > 2.0) {
	    	   resize();
	       }
	    }
        private void resize() {
			LinkedList<HMNode>[] ob = buckets;
			buckets = new LinkedList[2 * ob.length];
			for(int i = 0; i < buckets.length; i++) {
				buckets[i] = new LinkedList<>();
			}
			size = 0;
			for(int bi = 0; bi < ob.length; bi++) {
				LinkedList<HMNode> ll = ob[bi];
				for(int i = 0; i < ll.size(); i++) {
					put(ll.get(i).key, ll.get(i).value);
				}
			}
		}

//      returns data index   
	    private int findWithInBucket(K key, int bi) {
			
	    	for(int i = 0; i < buckets[bi].size(); i++) {
	    		if(buckets[bi].get(i).key.equals(key)) {
	    			return i;
	    		}
	    	}
	    	return -1;
		}
//      returns bucket index -> 0 to buckets.length - 1
		private int hashFunction(K key) {
			return Math.abs(key.hashCode()) % buckets.length;
		}

		public V get(K key) {
			 int bi = hashFunction(key);
		     int di = findWithInBucket(key, bi);
		     if(di == -1) {
//		    	   key doesn't exist in the map
		    	return null;
		    	   
		     } else {
		    	 return buckets[bi].get(di).value;
		     }
	    }

	    public boolean containsKey(K key) {
	    	 int bi = hashFunction(key);
		     int di = findWithInBucket(key, bi);
		     if(di == -1) {
//		    	   key doesn't exist in the map
		    	return false;	   
		     } else {
		    	 return true;
		     }
	    }

	    public V remove(K key) {
	    	 int bi = hashFunction(key);
		     int di = findWithInBucket(key, bi);
		     if(di == -1) {
//		    	   key doesn't exist in the map
		    	 return null;	   
		     } else {
		    	 V rv = buckets[bi].get(di).value;
		    	 buckets[bi].remove(di);
		    	 size--;
		    	 return rv;
		     }
	    }

	    public ArrayList<K> keyset() {
	        ArrayList<K> keys = new ArrayList<>();
	        for(int bi = 0; bi < buckets.length; bi++) {
	        	LinkedList<HMNode> ll = buckets[bi];
	        	for(int i = 0; i < ll.size(); i++) {
	        		keys.add(ll.get(i).key);
	        	}
	        }
	        return keys;
	    }

	    public int size() {
	        return this.size();
	    }

	   public void display() {
	      System.out.println("Display Begins");
	      for (int bi = 0; bi < buckets.length; bi++) {
	        System.out.print("Bucket" + bi + " ");
	        for (HMNode node : buckets[bi]) {
	          System.out.print( node.key + "@" + node.value + " ");
	        }
	        System.out.println(".");
	      }
	      System.out.println("Display Ends");
	  }
	}

	  public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    HashMap<String, Integer> map = new HashMap();

	    String str = br.readLine();
	    while (str.equals("quit") == false) {
	      if (str.startsWith("put")) {
	        String[] parts = str.split(" ");
	        String key = parts[1];
	        Integer val = Integer.parseInt(parts[2]);
	        map.put(key, val);
	      } else if (str.startsWith("get")) {
	        String[] parts = str.split(" ");
	        String key = parts[1];
	        System.out.println(map.get(key));
	      } else if (str.startsWith("containsKey")) {
	        String[] parts = str.split(" ");
	        String key = parts[1];
	        System.out.println(map.containsKey(key));
	      } else if (str.startsWith("remove")) {
	        String[] parts = str.split(" ");
	        String key = parts[1];
	        System.out.println(map.remove(key));
	      } else if (str.startsWith("size")) {
	        System.out.println(map.size());
	      } else if (str.startsWith("keyset")) {
	        System.out.println(map.keyset());
	      } else if (str.startsWith("display")) {
	        map.display();
	      }
	      str = br.readLine();
	    }
	  }
}
